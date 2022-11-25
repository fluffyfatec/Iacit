package com.fluffyiacit.api.controller;

import com.fluffyiacit.api.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import DTO.LoginDTO;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired(required = true)
	LoginService loginService;
	
	@PostMapping
	public ModelAndView login(@RequestBody LoginDTO loginDTO) {
		
		return loginService.login(loginDTO);
	}
}
