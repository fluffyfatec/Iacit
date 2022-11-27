package com.fluffyiacit.api.controller;

import com.fluffyiacit.api.service.ListaEstacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/list")
public class ListEstacaoController {
	
	@Autowired
	ListaEstacaoService estacaoService;
	
	@GetMapping
	private ModelAndView listar(){
		
		ModelAndView retorno = estacaoService.execute();
		return retorno;
	}

}
