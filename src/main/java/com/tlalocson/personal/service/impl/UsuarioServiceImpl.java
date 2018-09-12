package com.tlalocson.personal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlalocson.personal.entity.UsuarioEntity;
import com.tlalocson.personal.model.UsuarioModel;
import com.tlalocson.personal.model.converter.UsuarioConverter;
import com.tlalocson.personal.repository.RolMapper;
import com.tlalocson.personal.repository.UsuarioMapper;
import com.tlalocson.personal.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioMapper usuarioMapper;	
	
	@Autowired
	private RolMapper rolMapper;
	
	@Autowired
	private UsuarioConverter usuarioConverter;

	@Override
	public UsuarioModel login(String usuario) {
		Map<String, Object> mapParameters = new HashMap<>();
		mapParameters.put("p_usuario", usuario);
		UsuarioEntity entity = usuarioMapper.login(mapParameters);
		entity.setRoles(rolMapper.getRolesUsuario(entity.getIdUsuario()));
		return usuarioConverter.getModelFromEntity(entity);
	}
}
