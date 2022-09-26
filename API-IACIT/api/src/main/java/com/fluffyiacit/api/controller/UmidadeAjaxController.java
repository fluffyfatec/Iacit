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


@Controller
@RequestMapping
public class UmidadeAjaxController {

	@Autowired(required = true)
	private UmidadeRepository umidade;
	
	@RequestMapping(value = { "/Umidade" }, method = RequestMethod.GET)
	public ModelAndView filtroMenuLateral() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ViewUmidadeModal> graUmidade = umidade.listarGraphUmidade("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graUmidade", graUmidade);
		for (ViewUmidadeModal objview : graUmidade) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}
		
		modelAndView.setViewName("Umidade");
		return modelAndView;
	}

}
