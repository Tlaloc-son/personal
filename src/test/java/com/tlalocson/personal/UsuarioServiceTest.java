package com.tlalocson.personal;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlalocson.personal.model.UsuarioModel;
import com.tlalocson.personal.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PersonalApplication.class)
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	public void login() {
		UsuarioModel obj = usuarioService.login("CIVC");
		assertNotNull(obj);
	}
}
