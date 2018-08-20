package com.tlalocson.personal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlalocson.personal.entity.RolEntity;
import com.tlalocson.personal.model.RolModel;
import com.tlalocson.personal.model.converter.RolConverter;
import com.tlalocson.personal.repository.RolMapper;
import com.tlalocson.personal.service.RolService;

@Service("rolService")
public class RolServiceImpl implements RolService{	
	
	@Autowired
	private RolMapper rolMapper;
	
	@Autowired
	private RolConverter rolConverter;
	
	@Override
	public List<RolModel> getRoles() {
		
		return null;
	}

	@Override
	public RolModel getRol(int idRol) {
		RolEntity entity = rolMapper.getRol(idRol);
		return null;
	}

}
