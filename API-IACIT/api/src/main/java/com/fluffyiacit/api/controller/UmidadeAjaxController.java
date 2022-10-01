package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import com.fluffyiacit.api.modal.FiltroModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.repository.UmidadeRepository;


@Controller
@RequestMapping
public class UmidadeAjaxController {


	@Autowired(required = true)
	private UmidadeRepository umidaderepository;


	@RequestMapping(value = { "/umidade" }, method = RequestMethod.GET) //
	public ModelAndView telaUmidade() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ViewUmidadeModal> graUmidade = umidaderepository.listarGraphUmidade("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graUmidade", graUmidade);
		for (ViewUmidadeModal objview : graUmidade) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}
		
		modelAndView.setViewName("Umidade"); //
		return modelAndView;
	}

	@RequestMapping(value = { "/umidade/search" }, method = RequestMethod.GET)
	public ModelAndView telaUmidadeFiltrada(FiltroModal filtroModal) {

		ModelAndView modelAndView = new ModelAndView();

		filtroModal.setEstacaoNome("SAO PAULO - INTERLAGOS");
		filtroModal.setEstacaoEstado("SP");
		filtroModal.setDataHoraInicial("2022-04-15 10:00:00");
		filtroModal.setDataHoraFinal("2022-04-28 10:00:00");


		List<ViewUmidadeModal> graUmidadeFiltro = umidaderepository.listarGraphUmidade(filtroModal.getEstacaoEstado(), filtroModal.getEstacaoNome(),Timestamp.valueOf(filtroModal.getDataHoraInicial()),Timestamp.valueOf(filtroModal.getDataHoraFinal()));
		modelAndView.addObject("graUmidadeFiltro", graUmidadeFiltro);
		for (ViewUmidadeModal objview : graUmidadeFiltro) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}


		modelAndView.setViewName("Umidade");
		return modelAndView;

	}

}
