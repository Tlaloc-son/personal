package com.tlalocson.personal.service;

import java.util.List;

import com.tlalocson.personal.model.RolModel;

public interface RolService {

	public List<RolModel> getRoles();
	public RolModel getRol(int idRol);
}
