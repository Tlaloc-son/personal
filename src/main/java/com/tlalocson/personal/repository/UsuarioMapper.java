package com.tlalocson.personal.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import com.tlalocson.personal.entity.UsuarioEntity;

@Mapper
@Repository
public interface UsuarioMapper {

	@Select("select " + 
			"u.`id_usuario`, " + 
			"u.`usuario`, " + 
			"u.`password`, " + 
			"u.`id_status_usuario` " + 
			"from " + 
			"usuario u")
	@Results({
	  @Result(property = "idUsuario", column = "id_usuario", id = true),
	  @Result(property = "usuario", column = "usuario"),
	  @Result(property = "password", column = "password"),
	  @Result(property = "idStatusUsuario", column = "id_status_usuario")
	}) 
	List<UsuarioEntity> getUsuariosMapper();
	
	@ResultMap("getUsuariosMapper-void")
	@Select("call prueba.sp_usuario_login(#{p_usuario, jdbcType=VARCHAR, mode=IN})")
	@Options(statementType = StatementType.CALLABLE)
	UsuarioEntity login(Map<String, Object> mapParameters);
	
}
