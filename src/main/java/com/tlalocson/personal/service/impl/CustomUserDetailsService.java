package com.tlalocson.personal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tlalocson.personal.entity.RolEntity;
import com.tlalocson.personal.entity.UsuarioEntity;

@Service("usuarioService")
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity entityUsuario = new UsuarioEntity();
		entityUsuario.setIdUsuario(1);
		entityUsuario.setUsuario("CIVC");
		entityUsuario.setPassword("$2a$10$67FZ4BUvmWeOuaTGI7j.8u059VFu.jKwndiVgSjfdD/LwjbyXUUD2");
		
		RolEntity rol = new RolEntity();
		rol.setIdRol(1);
		rol.setRol("Super-admin");
		
		List<RolEntity> entityRols = new ArrayList<>();
		entityRols.add(rol);
		
		entityUsuario.setRoles(entityRols);
		return convertToUserSecurity(entityUsuario);
	}

	private User convertToUserSecurity(UsuarioEntity entityUsuario) {
		List<GrantedAuthority> authorities = convertToUserSecurity(entityUsuario.getRoles());		
		return new User(entityUsuario.getUsuario(), entityUsuario.getPassword(), authorities);
	}
	
	private List<GrantedAuthority> convertToUserSecurity(List<RolEntity> entityRols) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RolEntity rol : entityRols) {
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		return authorities;
	}
}
