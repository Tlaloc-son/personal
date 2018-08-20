package com.tlalocson.personal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

import com.tlalocson.personal.entity.RolEntity;

@Mapper
@Repository
public interface RolMapper {

	@Results(id = "rolResult", value = {
	  @Result(property = "idRol", column = "id_rol", id = true),
	  @Result(property = "rol", column = "rol")	  
	})
	@Select("select id_rol, rol from cat_rol")
	List<RolEntity> getRoles();
	
	@Results(id = "rolResult", value = {
	  @Result(property = "idRol", column = "id_rol", id = true),
	  @Result(property = "rol", column = "rol")	  
	})
	@Select("select id_rol, rol from cat_rol where id_rol = #{idRol}")
	RolEntity getRol(int idRol);
}
