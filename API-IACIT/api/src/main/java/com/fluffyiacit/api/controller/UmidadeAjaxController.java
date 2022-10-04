package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.repository.UmidadeRepository;

import DTO.FiltroDatasDTO;

@Controller
@RequestMapping
public class UmidadeAjaxController {

	@Autowired(required = true)
	private UmidadeRepository umidaderepository;

	@RequestMapping(value = { "/umidade" }, method = RequestMethod.GET)
	public ModelAndView telaUmidade() {
		ModelAndView modelAndView = new ModelAndView();

		List<ViewUmidadeModal> graUmidade = umidaderepository.listRange("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"), Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graUmidade", graUmidade);
		for (ViewUmidadeModal objview : graUmidade) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}

		modelAndView.setViewName("Umidade");
		return modelAndView;
	}

	@RequestMapping(value = { "/umidade/search" }, method = RequestMethod.GET)
	public ModelAndView telaUmidadeFiltrada(FiltroDatasDTO filtroDatasDto) {

		ModelAndView modelAndView = new ModelAndView();

		filtroDatasDto.setEstacaoNome("SAO PAULO - INTERLAGOS");
		filtroDatasDto.setEstacaoEstado("SP");
		filtroDatasDto.setDataHoraInicial("2022-04-15 10:00:00");
		filtroDatasDto.setDataHoraFinal("2022-04-28 10:00:00");

		if (!umidaderepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()))) {
			System.out.println("A data inserida é inferior a primeira data presente no banco");
			modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
			modelAndView.setViewName("Umidade");
			return modelAndView;
		}

		if (!umidaderepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()))) {
			System.out.println("A data inserida é posterior a ultima data presente no banco");
			modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
			modelAndView.setViewName("Umidade");
			return modelAndView;
		}

		List<ViewUmidadeModal> graUmidadeFiltro = umidaderepository.listRange(filtroDatasDto.getEstacaoEstado(),
				filtroDatasDto.getEstacaoNome(), Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()),
				Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()));
		modelAndView.addObject("graUmidadeFiltro", graUmidadeFiltro);
		for (ViewUmidadeModal objview : graUmidadeFiltro) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}

		modelAndView.setViewName("Umidade");
		return modelAndView;

	}

}
