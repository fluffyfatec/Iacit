package com.fluffyiacit.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.EstacaoModal;
import com.fluffyiacit.api.modal.PrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.repositorios.PrecipitacaoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired(required = true)
	private PrecipitacaoRepository precipitacao;

	@RequestMapping(value = {"/teste"}, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
	
	// BORA BILL
	List<ViewPrecipitacaoModal> envioteste = (List<ViewPrecipitacaoModal>) precipitacao.listar("SP", "São Paulo", "A702");
	modelAndView.addObject("teste_envio",envioteste);
	
	//INFORMANDO A PAGINA QUE SERA MOSTRADA
			modelAndView.setViewName("teste");
			return modelAndView;
	}
}
