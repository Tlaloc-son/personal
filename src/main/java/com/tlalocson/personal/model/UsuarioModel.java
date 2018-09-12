package com.tlalocson.personal.model;

import java.util.List;

import com.tlalocson.personal.entity.RolEntity;

public class UsuarioModel {

	private int idUsuario;
	private String usuario;
	private String password;
	private int idStatusUsuario;
	private String statusUsuario;
	private List<RolEntity> roles;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdStatusUsuario() {
		return idStatusUsuario;
	}

	public void setIdStatusUsuario(int idStatusUsuario) {
		this.idStatusUsuario = idStatusUsuario;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public List<RolEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RolEntity> roles) {
		this.roles = roles;
	}

}
