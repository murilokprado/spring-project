package com.spring.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.example.model.User;
import com.spring.example.repository.UserInterface;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserInterface userInterface;
	
	@GetMapping("/new")
	public ModelAndView newUser(User user) {
		ModelAndView modelAndView = new ModelAndView("user/user-register");
		
		modelAndView.addObject(user);
		
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView update(@PathVariable Long id) {
		return newUser(userInterface.findOne(id));
	}
	
	@PostMapping("/new")
	public ModelAndView save(@Valid User user, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return newUser(user);
		}
		
		userInterface.save(user);
		
		attributes.addFlashAttribute("message", "Usuário salvo com Sucesso!");
		
		return new ModelAndView("redirect:/user/new");
	}
	
	@GetMapping
	public ModelAndView listOfUser() {
		ModelAndView modelAndView = new ModelAndView("user/user-list");
		
		modelAndView.addObject("userList", userInterface.findAll());
		
		return modelAndView;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		userInterface.delete(id);
		attributes.addFlashAttribute("message", "Usuário removido com sucesso.");
		
		return "redirect:/user";
	}
}
