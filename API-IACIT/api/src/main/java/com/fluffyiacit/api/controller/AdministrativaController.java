package com.fluffyiacit.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewFiltroEstacao;
import com.fluffyiacit.api.repository.FiltroEstacaoRepository;
import com.fluffyiacit.api.service.ServiceAdm;

import DTO.EstacaoDTO;

@Controller
@RequestMapping("/api/estacao")

public class AdministrativaController {

	@Autowired
	private ServiceAdm adm;
	
	@Autowired(required = true)
	private FiltroEstacaoRepository filtroestacaorepository;
	
	@PostMapping
	public ModelAndView AdministrativaController(@RequestBody EstacaoDTO ativas) {
		return adm.update(ativas);

	}
	

	
//	 FILTRO AJAX - ESTACAO
	@RequestMapping(value = { "/est/{id}" }, method = RequestMethod.GET)
	public ModelAndView filtroAjax(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();

		List<ViewFiltroEstacao> filtro = filtroestacaorepository.listar(id);
		modelAndView.addObject("filtro", filtro);

		 //INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("AjaxTabEstacao");
		return modelAndView;
	}

}
