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
import com.fluffyiacit.api.repository.LogRepository;
import com.fluffyiacit.api.service.LogService;
import com.fluffyiacit.api.service.ServiceAdm;

import DTO.EstacaoDTO;
import DTO.LogUsuarioDTO;

@Controller
@RequestMapping("/api/estacao")

public class AdministrativaController {

	@Autowired
	private ServiceAdm adm;

	@Autowired
	private LogService log;
	
	@Autowired(required = true)
	private FiltroEstacaoRepository filtroestacaorepository;

	@Autowired(required = true)
	private LogRepository logrepository;
	
	@PostMapping
	public ModelAndView AdministrativaController(@RequestBody EstacaoDTO ativas) {
		return adm.update(ativas);
	}
	
	@RequestMapping(value = { "/salvar" }, method = RequestMethod.POST)
	public ModelAndView editarStatus(EstacaoDTO estacao) {
		ModelAndView modelAndView = new ModelAndView();
		estacao.getEstacaoNome();
		estacao.getEstacaoEstado();
		estacao.getEstacaoStatus();
		return adm.update(estacao);
	}

	//ATUALIZAR
	@RequestMapping(value = { "/{estacaoNome}/{estacaoStatus}" }, method = RequestMethod.GET)
	public ModelAndView atualizar(@PathVariable("estacaoNome") String estacaoNome,
            					   	@PathVariable("estacaoStatus") String estacaoStatus) {
		EstacaoDTO estacao = new EstacaoDTO();
		estacao.setEstacaoNome(estacaoNome);
		estacao.setEstacaoStatus(estacaoStatus);
		return adm.update(estacao);
	}
	
	//EDITAR
	@RequestMapping(value = { "/editar/{estacaoNome}" }, method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("estacaoNome") String estacaoNome
            					   	) {
		EstacaoDTO estacao = new EstacaoDTO();
		estacao.setEstacaoNome(estacaoNome);
		return adm.listar(estacao);
	}
	
	
//	 FILTRO AJAX - ESTACAO
	@RequestMapping(value = { "/est/{id}" }, method = RequestMethod.GET)
	public ModelAndView filtroEstacao(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();

		List<ViewFiltroEstacao> filtro = filtroestacaorepository.listar(id);
		modelAndView.addObject("filtro", filtro);

		 //INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("AjaxTabEstacao");
		return modelAndView;
	}
	@RequestMapping("/log")
	@PostMapping
    public ModelAndView LogController(@RequestBody LogUsuarioDTO ativas) {
        return log.listar(ativas);
        
    }

}
