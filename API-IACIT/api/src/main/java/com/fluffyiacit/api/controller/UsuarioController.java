package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fluffyiacit.api.service.UsuarioService;

@RestController
@RequestMapping(value = "/cadastro")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
 

    @PostMapping(value = "/deletar/ajax/{usuarioUsername}")
    public void delete(@PathVariable("usuarioUsername") String usuarioUsername ){
		usuarioService.deletar(usuarioUsername);
	
    }
}