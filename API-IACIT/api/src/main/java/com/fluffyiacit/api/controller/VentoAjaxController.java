package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewVentoModal;
import com.fluffyiacit.api.repository.VentoRepository;

import DTO.FiltroDatasDTO;

@Controller
@RequestMapping
public class VentoAjaxController {

	@Autowired(required = true)
	private VentoRepository ventoRepository;

	@RequestMapping(value = { "/vento" }, method = RequestMethod.GET)
	public ModelAndView telaVento() {
		ModelAndView modelAndView = new ModelAndView();

		List<ViewVentoModal> graVento = ventoRepository.listRange("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"), Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graVento", graVento);
		for (ViewVentoModal objview : graVento) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}

		modelAndView.setViewName("Vento");
		return modelAndView;

	}

	@RequestMapping(value = { "/vento/search" }, method = RequestMethod.GET)
	public ModelAndView telaVentoFiltrada(FiltroDatasDTO filtroDatasDto) {

		ModelAndView modelAndView = new ModelAndView();

		filtroDatasDto.setEstacaoNome("SAO PAULO - INTERLAGOS");
		filtroDatasDto.setEstacaoEstado("SP");
		filtroDatasDto.setDataHoraInicial("2022-04-15 10:00:00");
		filtroDatasDto.setDataHoraFinal("2022-04-28 10:00:00");

		if (!ventoRepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()))) {
			System.out.println("A data inserida é inferior a primeira data presente no banco");
			modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
			modelAndView.setViewName("Vento");
			return modelAndView;
		}

		if (!ventoRepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()))) {
			System.out.println("A data inserida é posterior a ultima data presente no banco");
			modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
			modelAndView.setViewName("Vento");
			return modelAndView;
		}

		List<ViewVentoModal> graVentoFiltro = ventoRepository.listRange(filtroDatasDto.getEstacaoEstado(),
				filtroDatasDto.getEstacaoNome(), Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()),
				Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()));
		modelAndView.addObject("graVentoFiltro", graVentoFiltro);
		for (ViewVentoModal objview : graVentoFiltro) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}

		modelAndView.setViewName("Vento");
		return modelAndView;

	}

}
