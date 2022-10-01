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

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.repository.PrecipitacaoRepository;


@Controller
@RequestMapping
public class PrecipitacaoAjaxController {


	@Autowired(required = true)
	private PrecipitacaoRepository precipitacaorepository;


	@RequestMapping(value = { "/precipitacao" }, method = RequestMethod.GET) //
	public ModelAndView telaPrecipitacao() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ViewPrecipitacaoModal> graPrecipitacao = precipitacaorepository.listarGraphPrecipitacao("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graPrecipitacao", graPrecipitacao);
		for (ViewPrecipitacaoModal objview : graPrecipitacao) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}
		
		modelAndView.setViewName("Precipitacao"); //
		return modelAndView;
	
	}


	@RequestMapping(value = { "/precipitacao/search" }, method = RequestMethod.GET)
	public ModelAndView telaPrecipitacaoFiltrada(FiltroModal filtroModal) {

		ModelAndView modelAndView = new ModelAndView();

		filtroModal.setEstacaoNome("SAO PAULO - INTERLAGOS");
		filtroModal.setEstacaoEstado("SP");
		filtroModal.setDataHoraInicial("2022-04-15 10:00:00");
		filtroModal.setDataHoraFinal("2022-04-28 10:00:00");


		List<ViewPrecipitacaoModal> graPrecipitacaoFiltro = precipitacaorepository.listarGraphPrecipitacao(filtroModal.getEstacaoEstado(), filtroModal.getEstacaoNome(),Timestamp.valueOf(filtroModal.getDataHoraInicial()),Timestamp.valueOf(filtroModal.getDataHoraFinal()));
		modelAndView.addObject("graPrecipitacaoFiltro", graPrecipitacaoFiltro);
		for (ViewPrecipitacaoModal objview : graPrecipitacaoFiltro) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}


		modelAndView.setViewName("Precipitacao");
		return modelAndView;

	}

}



