package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fluffyiacit.api.service.DeleteUsuarioService;

@RestController
@RequestMapping
public class DeleteUsuarioController {
    
    @Autowired
    DeleteUsuarioService usuarioService;
 

    @PostMapping(value = "/deletar/ajax/{usuarioUsername}")
    public void delete(@PathVariable("usuarioUsername") String usuarioUsername ){
		usuarioService.deletar(usuarioUsername);
	
    }
}