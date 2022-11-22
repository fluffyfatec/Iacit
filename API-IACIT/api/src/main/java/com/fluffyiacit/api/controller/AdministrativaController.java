package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.service.ServiceAdm;

import DTO.EstacaoDTO;

@Controller
@RequestMapping("/api/estacao")

public class AdministrativaController {

	@Autowired
	private ServiceAdm adm;

	@PostMapping
	public ModelAndView AdministrativaController(@RequestBody EstacaoDTO ativas) {
		return adm.update(ativas);

	}

}
