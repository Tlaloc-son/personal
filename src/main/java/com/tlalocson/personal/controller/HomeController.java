package com.tlalocson.personal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	public static final Log LOGGER = LogFactory.getLog(HomeController.class);
	
	@GetMapping("")
	public String emptyView() {
		return "redirect:/home/";
	}
	
	@GetMapping("/")
	public ModelAndView getHomeView() {
		ModelAndView modelView = new ModelAndView("home");		
		modelView.addObject("mensaje", "PANTALLA DE HOME");		
		return modelView;
	}
}
