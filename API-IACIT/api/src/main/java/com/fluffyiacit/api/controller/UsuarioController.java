package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.service.UsuarioService;

import DTO.UsuarioDTO;

@RestController
@RequestMapping(value = "/cadastro")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping
    private ModelAndView cadastrar(@RequestBody UsuarioDTO usuario) {
        
    	
       ModelAndView modelandview = usuarioService.criarUsuario(usuario);
       return modelandview;
    }
    
 
    
	  

}

