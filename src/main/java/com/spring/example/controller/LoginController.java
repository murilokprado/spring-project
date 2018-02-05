package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/enter")
	public ModelAndView enter() {
		ModelAndView modelAndView = new ModelAndView("user/enter");
		
		return modelAndView;
	}

}
