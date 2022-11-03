package com.fluffyiacit.api.controller;

import com.fluffyiacit.api.service.UpdateUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import DTO.UsuarioRequestDTO;

@Controller
@RequestMapping(value="/update")
public class UpdateUsuarioController {
	
	@Autowired
	UpdateUsuarioService updateUsuarioService;
	
	@PostMapping
	public void handle(@RequestBody UsuarioRequestDTO data) {
				
		updateUsuarioService.execute(data);
	}

}
