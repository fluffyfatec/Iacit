package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.UsuarioRepository;
import com.fluffyiacit.api.service.UsuarioService;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired(required = true)
	private UsuarioService service;
	
	 @Autowired
	 private UsuarioRepository repository;
	
	@RequestMapping(value = { "/Usuario" }, method = RequestMethod.GET)
	public ModelAndView telaUsuario() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}

	@RequestMapping(value = {"/deletar/{codUsuario}"} , method = RequestMethod.GET)
	public ModelAndView deletar(@PathVariable("codUsuario") Integer codUsuario) {
		ModelAndView modelAndView = new ModelAndView();
		UsuarioModal usuario = repository.findById(codUsuario).get();
		repository.deleteById(codUsuario);
		return modelAndView;
	}

}
