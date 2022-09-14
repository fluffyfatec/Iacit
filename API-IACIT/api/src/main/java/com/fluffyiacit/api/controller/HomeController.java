package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	List<ViewPrecipitacaoModal> envioteste = precipitacao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	
	
	modelAndView.addObject("teste_envio", envioteste);
	System.out.println("teste_envio:" + envioteste);
	//System.out.println("Conta:" + usuariomodal.getSenha());
	
	
	//INFORMANDO A PAGINA QUE SERA MOSTRADA
			modelAndView.setViewName("teste");
			return modelAndView;
	}
}
