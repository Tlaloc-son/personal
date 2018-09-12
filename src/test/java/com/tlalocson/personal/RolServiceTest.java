package com.tlalocson.personal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlalocson.personal.model.RolModel;
import com.tlalocson.personal.service.RolService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PersonalApplication.class)
public class RolServiceTest {

	@Autowired
	private RolService rolService;
	
	@Test
	public void getRoles() {
		List<RolModel> roles = rolService.getRoles();
		assertTrue(roles.size() > 0);
	}
	
	@Test
	public void getRol() {		
		RolModel model = rolService.getRol(1);
		assertNotNull(model);
	}
}
