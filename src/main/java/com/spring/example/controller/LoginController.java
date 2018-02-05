package com.spring.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.example.model.User;
import com.spring.example.repository.UserInterface;

@Controller
public class LoginController {
	
	
	@Autowired
	private UserInterface userInterface;
	
	@RequestMapping(method = RequestMethod.GET, path = "/enter")
	public ModelAndView enter() {
		ModelAndView modelAndView = new ModelAndView("user/enter");
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public ModelAndView listOfUser() {
		ModelAndView modelAndView = new ModelAndView("user/user-list");
		
		modelAndView.addObject("userList", userInterface.findAll());
		
		return modelAndView;
	}}
