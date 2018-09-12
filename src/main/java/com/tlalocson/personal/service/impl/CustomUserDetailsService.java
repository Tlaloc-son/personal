package com.tlalocson.personal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tlalocson.personal.entity.RolEntity;
import com.tlalocson.personal.model.UsuarioModel;
import com.tlalocson.personal.service.UsuarioService;

@Service("loginUserService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioModel objusuario = usuarioService.login(username);		
		return convertToUserSecurity(objusuario);
	}

	private User convertToUserSecurity(UsuarioModel objusuario) {
		List<GrantedAuthority> authorities = convertToUserSecurity(objusuario.getRoles());		
		return new User(objusuario.getUsuario(), objusuario.getPassword(), authorities);
	}
	
	private List<GrantedAuthority> convertToUserSecurity(List<RolEntity> entityRols) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RolEntity rol : entityRols) {
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		return authorities;
	}
}
