package com.tlalocson.personal.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.tlalocson.personal.entity.RolEntity;
import com.tlalocson.personal.repository.RolMapper;

@Controller
@RequestMapping("/cat")
public class CatController {

	public static final Log LOGGER = LogFactory.getLog(CatController.class);
	
	@Autowired
	private RolMapper rolMapper;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getRoles() {
		Gson gson = new Gson();
		List<RolEntity> roles = rolMapper.getRoles();
		String jsonResponse = gson.toJson(roles);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}
}
