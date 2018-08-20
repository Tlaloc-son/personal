package com.tlalocson.personal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

	public static final Log LOGGER = LogFactory.getLog(LoginController.class);
	public static final String SING_IN = "sign-in";
	public static final String HOME = "home";
	
	@GetMapping("")
	public String login(Model model) {
		model.addAttribute("mensaje", "Prueba login");
		return SING_IN;
	}
	
	@GetMapping({"/success", "/"})
	public ModelAndView loginSuccess() {						
		return new ModelAndView(HOME);
	}
}
