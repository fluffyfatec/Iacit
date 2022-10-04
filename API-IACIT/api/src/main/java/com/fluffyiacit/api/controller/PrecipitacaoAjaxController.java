package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.repository.PrecipitacaoRepository;

import DTO.FiltroDatasDTO;

@Controller
@RequestMapping
public class PrecipitacaoAjaxController {

	@Autowired(required = true)
	private PrecipitacaoRepository precipitacaorepository;

	@RequestMapping(value = { "/precipitacao" }, method = RequestMethod.GET)
	public ModelAndView telaPrecipitacao() {
		ModelAndView modelAndView = new ModelAndView();

		List<ViewPrecipitacaoModal> rangePrecipitacao = precipitacaorepository.listRange("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"), Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graPrecipitacao", rangePrecipitacao);
		for (ViewPrecipitacaoModal objview : rangePrecipitacao) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}
		modelAndView.setViewName("Precipitacao");
		return modelAndView;
	}

	@RequestMapping(value = { "/precipitacao/search" }, method = RequestMethod.GET)
	public ModelAndView telaPrecipitacaoFiltrada(FiltroDatasDTO filtroDatasDto) {

		ModelAndView modelAndView = new ModelAndView();

		filtroDatasDto.setEstacaoNome("SAO PAULO - INTERLAGOS");
		filtroDatasDto.setEstacaoEstado("SP");
		filtroDatasDto.setDataHoraInicial("2022-04-15 10:00:00");
		filtroDatasDto.setDataHoraFinal("2022-04-28 10:00:00");

		if (!precipitacaorepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()))) {
			System.out.println("A data inserida é inferior a primeira data presente no banco");
			modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
			modelAndView.setViewName("Precipitacao");
			return modelAndView;
		}

		if (!precipitacaorepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()))) {
			System.out.println("A data inserida é posterior a ultima data presente no banco");
			modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
			modelAndView.setViewName("Precipitacao");
			return modelAndView;
		}

		List<ViewPrecipitacaoModal> rangePrecipitacao = precipitacaorepository.listRange(
				filtroDatasDto.getEstacaoEstado(), filtroDatasDto.getEstacaoNome(),
				Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()),
				Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()));
		modelAndView.addObject("graPrecipitacaoFiltro", rangePrecipitacao);
		for (ViewPrecipitacaoModal objview : rangePrecipitacao) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}

		modelAndView.setViewName("Precipitacao");
		return modelAndView;

	}
}
