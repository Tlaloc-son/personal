package com.tlalocson.personal.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.tlalocson.personal.entity.UsuarioEntity;
import com.tlalocson.personal.model.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter implements Converter<UsuarioEntity, UsuarioModel> {

	public static final Log LOGGER = LogFactory.getLog(UsuarioConverter.class);

	@Override
	public UsuarioModel getModelFromEntity(UsuarioEntity entity) {
		UsuarioModel model = new UsuarioModel();
		try {
			model.setIdUsuario(entity.getIdUsuario());
			model.setUsuario(entity.getUsuario());
			model.setPassword(entity.getPassword());
			model.setStatusUsuario(entity.getStatusUsuario());
			model.setIdStatusUsuario(entity.getIdStatusUsuario());
			model.setRoles(entity.getRoles());
		} catch (Exception e) {
			LOGGER.info("Null UsuarioEntity");
		}

		return model;
	}

	@Override
	public UsuarioEntity getEntityFromModel(UsuarioModel model) {
		UsuarioEntity entity = new UsuarioEntity();
		try {
			entity.setIdUsuario(model.getIdUsuario());
			entity.setUsuario(model.getUsuario());
			entity.setPassword(model.getPassword());
			entity.setStatusUsuario(model.getStatusUsuario());
			entity.setIdStatusUsuario(model.getIdStatusUsuario());
			entity.setRoles(model.getRoles());
		} catch (Exception e) {
			LOGGER.info("Null UsuarioModel");
		}
		return entity;
	}

	@Override
	public List<UsuarioEntity> getEntitiesFromModels(List<UsuarioModel> models) {
		List<UsuarioEntity> entities = new ArrayList<>();
		for (UsuarioModel model : models) {
			entities.add(getEntityFromModel(model));
		}
		return entities;
	}

	@Override
	public List<UsuarioModel> getModelsFromEntities(List<UsuarioEntity> entities) {
		List<UsuarioModel> models = new ArrayList<>();
		for (UsuarioEntity entity : entities) {
			models.add(getModelFromEntity(entity));
		}
		return models;
	}

}
