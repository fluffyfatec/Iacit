package com.fluffyiacit.api.controller;



import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.FiltroModal;
import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.modal.ViewVentoModal;
import com.fluffyiacit.api.repository.PrecipitacaoRepository;
import com.fluffyiacit.api.repository.PressaoAtmRepository;
import com.fluffyiacit.api.repository.RadiacaoGlobalRepository;
import com.fluffyiacit.api.repository.TemperaturaRepository;
import com.fluffyiacit.api.repository.UmidadeRepository;
import com.fluffyiacit.api.repository.VentoRepository;

@Controller
@RequestMapping
public class HomeController {
	
	//REPOSITORY
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
	//
	
	//ENTRAR PAGINA INDEX
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView PaginaIndex() {
		ModelAndView modelAndView = new ModelAndView();

		FiltroModal filtromodal = new FiltroModal();

		//filtromodal.setEstacao_nome("DF");
		//filtromodal.setEstacao_estado("BRASILIA");
		//filtromodal.setCod_wmo("A001");
		//filtromodal.setDatahora_captacao("2020-01-01 00:00:00");
		
		filtromodal.setEstacao_nome("");
		filtromodal.setEstacao_estado("");
		filtromodal.setCod_wmo("");
		filtromodal.setDatahora_captacao("");
		modelAndView.addObject("filtro", filtromodal);
		
		// Lista Precipitacao
		
		List<ViewPrecipitacaoModal> envioteste = precipitacao.listar("0", "0", Timestamp.valueOf("2020-01-01 00:00:00"));	
		
		modelAndView.addObject("teste_precipitacao", envioteste);
	    
	
	
		// Lista Precipitacao
		List<ViewPressaoAtmModal> teste_atm = pressao.listar("0", "0", Timestamp.valueOf("2020-01-01 00:00:00"));
		modelAndView.addObject("teste_atm", teste_atm);														
		
		// Lista Radiacao
		List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listar("0", "0", Timestamp.valueOf("2020-01-01 00:00:00"));
		modelAndView.addObject("teste_radiacaoglobal", teste_radiacaoglobal);
		
		// Lista Temperatura
		List<ViewTemperaturaModal> teste_temperatura = temperatura.listar("0", "0", Timestamp.valueOf("2020-01-01 00:00:00"));
		modelAndView.addObject("teste_temperatura", teste_temperatura);
		
		
		// Lista Umidade
		List<ViewUmidadeModal> teste_umidade = umidade.listar("0", "0", Timestamp.valueOf("2020-01-01 00:00:00"));
		modelAndView.addObject("teste_umidade", teste_umidade);
		
		// Lista Vento
		List<ViewVentoModal> teste_vento = vento.listar("0", "0", Timestamp.valueOf("2020-01-01 00:00:00"));
		modelAndView.addObject("teste_vento", teste_vento);
		
		
		
		
		//INFORMANDO A PAGINA QUE SERA MOSTRADA
			modelAndView.setViewName("index");
			return modelAndView;
		//
	}

	
	//ENTRAR PAGINA INDEX
	@RequestMapping(value = {"/a"}, method = RequestMethod.POST)
	public ModelAndView a(FiltroModal filtromodal) {
		ModelAndView modelAndView = new ModelAndView();
		
		//System.out.println("1:" + filtromodal.getEstacao_nome());
		//System.out.println("2:" + filtromodal.getEstacao_estado());
		//System.out.println("3:" + filtromodal.getCod_wmo());
		//System.out.println("4:" + filtromodal.getDatahora_captacao());
		
		// Lista Precipitacao
		List<ViewPrecipitacaoModal> envioteste = precipitacao.listar(filtromodal.getEstacao_nome(), filtromodal.getEstacao_estado(), Timestamp.valueOf(filtromodal.getDatahora_captacao()));
		
		for (ViewPrecipitacaoModal objviewPrecipitacao:envioteste) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
		}
		modelAndView.addObject("teste_precipitacao", envioteste);
		
		// Lista Precipitacao
		List<ViewPressaoAtmModal> teste_atm = pressao.listar(filtromodal.getEstacao_nome(), filtromodal.getEstacao_estado(), Timestamp.valueOf(filtromodal.getDatahora_captacao()));
		
		for (ViewPressaoAtmModal objviewPressao:teste_atm) {
			if (objviewPressao.getPressao_atm_estacao() == null && objviewPressao.getPressao_atm_max() == null && objviewPressao.getPressao_atm_min() == null) {
				objviewPressao.setPressao_atm_estacao("N/A");
				objviewPressao.setPressao_atm_max("N/A");
				objviewPressao.setPressao_atm_min("N/A");
			}
		}
		modelAndView.addObject("teste_atm", teste_atm);
		
		// Lista Radiacao
		List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listar(filtromodal.getEstacao_nome(), filtromodal.getEstacao_estado(), Timestamp.valueOf(filtromodal.getDatahora_captacao()));
		for (ViewRadiacaoglobalModal objviewRadiacao:teste_radiacaoglobal) {
			if (objviewRadiacao.getRadiacao_global() == null) {
				objviewRadiacao.setRadiacao_global("N/A");
			}
		}
		modelAndView.addObject("teste_radiacaoglobal", teste_radiacaoglobal);
		
		// Lista Temperatura
		List<ViewTemperaturaModal> teste_temperatura = temperatura.listar(filtromodal.getEstacao_nome(), filtromodal.getEstacao_estado(), Timestamp.valueOf(filtromodal.getDatahora_captacao()));
		for (ViewTemperaturaModal objviewTemperatura:teste_temperatura) {
			if (objviewTemperatura.getTemperatura_ar() == null && objviewTemperatura.getTemperatura_max()== null && objviewTemperatura.getTemperatura_min() == null && objviewTemperatura.getTemperatura_orvalho_max() == null && objviewTemperatura.getTemperatura_orvalho_min() == null && objviewTemperatura.getTemperatura_ponto_orvalho() == null){
				objviewTemperatura.setTemperatura_ar("N/A");
				objviewTemperatura.setTemperatura_max("N/A");
				objviewTemperatura.setTemperatura_min("N/A");
				objviewTemperatura.setTemperatura_orvalho_max("N/A");
				objviewTemperatura.setTemperatura_orvalho_min("N/A");
				objviewTemperatura.setTemperatura_ponto_orvalho("N/A");
			}
		}
		modelAndView.addObject("teste_temperatura", teste_temperatura);
		
		// Lista Umidade
		List<ViewUmidadeModal> teste_umidade = umidade.listar(filtromodal.getEstacao_nome(), filtromodal.getEstacao_estado(), Timestamp.valueOf(filtromodal.getDatahora_captacao()));
		for (ViewUmidadeModal objviewUmidade:teste_umidade) {
			if (objviewUmidade.getUmidade_relativa_ar() == null && objviewUmidade.getUmidade_relativa_max() == null && objviewUmidade.getUmidade_relativa_min() == null ) {
				objviewUmidade.setUmidade_relativa_ar("N/A");
				objviewUmidade.setUmidade_relativa_max("N/A");
				objviewUmidade.setUmidade_relativa_min("N/A");
			}
		}
		modelAndView.addObject("teste_umidade", teste_umidade);
		
		// Lista Vento
		List<ViewVentoModal> teste_vento = vento.listar(filtromodal.getEstacao_nome(), filtromodal.getEstacao_estado(), Timestamp.valueOf(filtromodal.getDatahora_captacao()));
		for (ViewVentoModal objviewVento:teste_vento) {
			if (objviewVento.getVento_direcao_horario() == null && objviewVento.getVento_rajada_max() == null && objviewVento.getVento_velocidade() == null) {
				objviewVento.setVento_direcao_horario("N/A");
				objviewVento.setVento_rajada_max("N/A");
				objviewVento.setVento_velocidade("N/A");
			}
		}
		modelAndView.addObject("teste_vento", teste_vento);
		
		filtromodal.getEstacao_nome();
		filtromodal.getEstacao_estado();
		//filtromodal.getCod_wmo();
		filtromodal.getDatahora_captacao();
		modelAndView.addObject("filtro", filtromodal);
		
		//INFORMANDO A PAGINA QUE SERA MOSTRADA
			modelAndView.setViewName("index");
			return modelAndView;
		//
	}
	
	
	//PAGINA PARA TESTE//
//	@RequestMapping(value = {"/teste"}, method = RequestMethod.GET)
//	public ModelAndView formulario() {
//		ModelAndView modelAndView = new ModelAndView();
//	
//		// Lista Precipitacao
//		List<ViewPrecipitacaoModal> envioteste = precipitacao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-01-01 00:00:00"));
//		modelAndView.addObject("teste_precipitacao", envioteste);
//		
//		// Lista Precipitacao
//		List<ViewPressaoAtmModal> teste_atm = pressao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-01-01 00:00:00"));
//		modelAndView.addObject("teste_atm", teste_atm);
//		
//		// Lista Radiacao
//		List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-01-01 00:00:00"));
//		modelAndView.addObject("teste_radiacaoglobal", teste_radiacaoglobal);
//		
//		// Lista Temperatura
//		List<ViewTemperaturaModal> teste_temperatura = temperatura.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-01-01 00:00:00"));
//		modelAndView.addObject("teste_temperatura", teste_temperatura);
//		
//		// Lista Umidade
//		List<ViewUmidadeModal> teste_umidade = umidade.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-01-01 00:00:00"));
//		modelAndView.addObject("teste_umidade", teste_umidade);
//		
//		// Lista Vento
//		List<ViewVentoModal> teste_vento = vento.listar("DF", "BRASILIA","A001", Timestamp.valueOf("2020-01-01 00:00:00"));
//		modelAndView.addObject("teste_vento", teste_vento);
//																				
//		//INFORMANDO A PAGINA QUE SERA MOSTRADA
//			modelAndView.setViewName("teste");
//			return modelAndView;
//		
//		}


}
