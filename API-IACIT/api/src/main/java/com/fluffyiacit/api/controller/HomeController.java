package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.PressaoAtmosfericaModal;
import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.modal.ViewVentoModal;
import com.fluffyiacit.api.repositorios.PrecipitacaoRepository;
import com.fluffyiacit.api.repositorios.PressaoAtmRepository;
import com.fluffyiacit.api.repositorios.RadiacaoGlobalRepository;
import com.fluffyiacit.api.repositorios.TemperaturaRepository;
import com.fluffyiacit.api.repositorios.UmidadeRepository;
import com.fluffyiacit.api.repositorios.VentoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	

	@Autowired(required = true)
	private PrecipitacaoRepository precipitacao;

	@Autowired(required = true)
	private PressaoAtmRepository pressao;
	
	@Autowired(required = true)
	private RadiacaoGlobalRepository radiacao;
	
	@Autowired(required = true)
	private TemperaturaRepository temperatura;
	
	@Autowired(required = true)
	private UmidadeRepository umidade;
	
	@Autowired(required = true)
	private VentoRepository vento;
	

	@RequestMapping(value = {"/teste"}, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
	
	// BORA BILL
	List<ViewPrecipitacaoModal> envioteste = precipitacao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	

	// BORA BILL
	List<ViewPressaoAtmModal> teste_atm = pressao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	

	// BORA BILL
	List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	

	// BORA BILL
	List<ViewTemperaturaModal> teste_temperatura = temperatura.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	

	// BORA BILL
	List<ViewUmidadeModal> teste_umidade = umidade.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	

	// BORA BILL
	List<ViewVentoModal> teste_vento = vento.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-02-20 00:00:00"));
	
	
	modelAndView.addObject("teste_precipitacao", envioteste);
	System.out.println("teste_precipitacao:" + envioteste );
	

	modelAndView.addObject("teste_atm", teste_atm);
	System.out.println("teste_atm:" + teste_atm);
	
	
	modelAndView.addObject("teste_radiacaoglobal", teste_radiacaoglobal);
	System.out.println("teste_radiacaoglobal:" + teste_radiacaoglobal);
	

	modelAndView.addObject("teste_temperatura", teste_temperatura);
	System.out.println("teste_temperatura:" + teste_temperatura);
	
	modelAndView.addObject("teste_umidade", teste_umidade);
	System.out.println("teste_umidade:" + teste_umidade);
	
	modelAndView.addObject("teste_vento", teste_vento);
	System.out.println("teste_vento:" + teste_vento);
	
	
	
	//INFORMANDO A PAGINA QUE SERA MOSTRADA
			modelAndView.setViewName("teste");
			return modelAndView;
	}
}
