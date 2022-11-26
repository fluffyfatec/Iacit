package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.service.LoginService;

import DTO.LoginDTO;

@RestController
public class LoginController {

	@Autowired(required = true)
	LoginService loginService;
	

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView PaginaIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
		//
	}

	@PostMapping
	public ModelAndView login(@RequestBody LoginDTO loginDTO) {
		
		return loginService.login(loginDTO);
	}	




}