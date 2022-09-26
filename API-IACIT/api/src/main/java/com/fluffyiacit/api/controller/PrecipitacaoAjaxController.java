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


@Controller
@RequestMapping
public class PrecipitacaoAjaxController {
	@Autowired(required = true)
	private PrecipitacaoRepository precipitacaorepository;
	
	@RequestMapping(value = { "/Precipitacao" }, method = RequestMethod.GET) //
	public ModelAndView filtroMenuLateral() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ViewPrecipitacaoModal> graPrecipitacao = precipitacaorepository.listarGraphPrecipitacao("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
		modelAndView.addObject("graPrecipitacao", graPrecipitacao);
		for (ViewPrecipitacaoModal objview : graPrecipitacao) {
			System.out.println("1:" + objview.getDatahoraCaptacao());
		}
		
		modelAndView.setViewName("Precipitacao"); //
		return modelAndView;
	
	
	
}
}



