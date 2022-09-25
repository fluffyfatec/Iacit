package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.FiltroModal;
import com.fluffyiacit.api.modal.ViewFiltroEstacao;
import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.modal.ViewVentoModal;
import com.fluffyiacit.api.repository.FiltroEstacaoRepository;
import com.fluffyiacit.api.repository.PrecipitacaoRepository;
import com.fluffyiacit.api.repository.PressaoAtmRepository;
import com.fluffyiacit.api.repository.RadiacaoGlobalRepository;
import com.fluffyiacit.api.repository.TemperaturaRepository;
import com.fluffyiacit.api.repository.UmidadeRepository;
import com.fluffyiacit.api.repository.VentoRepository;


@Controller
@RequestMapping
public class HomeController {

	// REPOSITORY

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

	@Autowired(required = true)
	private FiltroEstacaoRepository filtroestacaorepository;

	// ENTRAR PAGINA INDEX
	
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView PaginaIndex() {
		ModelAndView modelAndView = new ModelAndView();

		FiltroModal filtromodal = new FiltroModal();

		filtromodal.setEstacaoNome("");
		filtromodal.setEstacaoEstado("");
		filtromodal.setCodWmo("");
		filtromodal.setDatahoraCaptacao("2022-06-28 10:00:00");
		modelAndView.addObject("filtro", filtromodal);

		// Lista Precipitacao
		List<ViewPrecipitacaoModal> teste_precipitacao = precipitacao.listar("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"));
		for (ViewPrecipitacaoModal objviewPrecipitacao : teste_precipitacao) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
		}
		modelAndView.addObject("teste_precipitacao", teste_precipitacao);

		// Lista Pressao
		List<ViewPressaoAtmModal> teste_atm = pressao.listar("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"));
		for (ViewPressaoAtmModal objviewPressao : teste_atm) {
			if (objviewPressao.getPressaoAtmEstacao() == null) {
				objviewPressao.setPressaoAtmEstacao("N/A");
			}
			if (objviewPressao.getPressaoAtmMax() == null) {
				objviewPressao.setPressaoAtmMax("N/A");
			}
			if (objviewPressao.getPressaoAtmMin() == null) {
				objviewPressao.setPressaoAtmMin("N/A");
			}
		}
		modelAndView.addObject("teste_atm", teste_atm);

		// Lista Radiacao
		List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listar("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"));
		for (ViewRadiacaoglobalModal objviewRadiacao : teste_radiacaoglobal) {
			if (objviewRadiacao.getRadiacaoGlobal() == null) {
				objviewRadiacao.setRadiacaoGlobal("N/A");
			}
		}
		modelAndView.addObject("teste_radiacaoglobal", teste_radiacaoglobal);

		// Lista Temperatura
		List<ViewTemperaturaModal> teste_temperatura = temperatura.listar("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"));
		for (ViewTemperaturaModal objviewTemperatura : teste_temperatura) {
			if (objviewTemperatura.getTemperaturaAr() == null) {
				objviewTemperatura.setTemperaturaAr("N/A");
			}
			if (objviewTemperatura.getTemperaturaMax() == null) {
				objviewTemperatura.setTemperaturaMax("N/A");
			}
			if (objviewTemperatura.getTemperaturaMin() == null) {
				objviewTemperatura.setTemperaturaMin("N/A");
			}
			if (objviewTemperatura.getTemperaturaOrvalhoMax() == null) {
				objviewTemperatura.setTemperaturaOrvalhoMax("N/A");
			}
			if (objviewTemperatura.getTemperaturaOrvalhoMin() == null) {
				objviewTemperatura.setTemperaturaOrvalhoMin("N/A");
			}
			if (objviewTemperatura.getTemperaturaPontoOrvalho() == null) {
				objviewTemperatura.setTemperaturaPontoOrvalho("N/A");
			}
		}
		modelAndView.addObject("teste_temperatura", teste_temperatura);

		// Lista Umidade
		List<ViewUmidadeModal> teste_umidade = umidade.listar("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"));
		for (ViewUmidadeModal objviewUmidade : teste_umidade) {
			if (objviewUmidade.getUmidadeRelativaAr() == null) {
				objviewUmidade.setUmidadeRelativaAr("N/A");
			}
			if (objviewUmidade.getUmidadeRelativaMax() == null) {
				objviewUmidade.setUmidadeRelativaMax("N/A");
			}
			if (objviewUmidade.getUmidadeRelativaMin() == null) {
				objviewUmidade.setUmidadeRelativaMin("N/A");
			}
		}
		modelAndView.addObject("teste_umidade", teste_umidade);

		// Lista Vento
		List<ViewVentoModal> teste_vento = vento.listar("SP", "SAO PAULO - INTERLAGOS",
				Timestamp.valueOf("2022-06-28 10:00:00"));
		for (ViewVentoModal objviewVento : teste_vento) {
			if (objviewVento.getVentoDirecaoHorario() == null) {
				objviewVento.setVentoDirecaoHorario("N/A");
			}
			if (objviewVento.getVentoRajadaMax() == null) {
				objviewVento.setVentoRajadaMax("N/A");
			}
			if (objviewVento.getVentoVelocidade() == null) {
				objviewVento.setVentoVelocidade("N/A");
			}
		}
		modelAndView.addObject("teste_vento", teste_vento);

		// INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("index");
		return modelAndView;
		//
	}

	// ENTRAR PAGINA INDEX FILTRADA
	@RequestMapping(value = { "/index" }, method = RequestMethod.POST)
	public ModelAndView PaginaIndexFiltrada(FiltroModal filtromodal) {
		ModelAndView modelAndView = new ModelAndView();

		// Lista Precipitacao
		List<ViewPrecipitacaoModal> teste_precipitacao = precipitacao.listar(filtromodal.getEstacaoNome(),
				filtromodal.getEstacaoEstado(), Timestamp.valueOf(filtromodal.getDatahoraCaptacao()));
		for (ViewPrecipitacaoModal objviewPrecipitacao : teste_precipitacao) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
		}
		modelAndView.addObject("teste_precipitacao", teste_precipitacao);

		// Lista Pressao
		List<ViewPressaoAtmModal> teste_atm = pressao.listar(filtromodal.getEstacaoNome(),
				filtromodal.getEstacaoEstado(), Timestamp.valueOf(filtromodal.getDatahoraCaptacao()));
		for (ViewPressaoAtmModal objviewPressao : teste_atm) {
			if (objviewPressao.getPressaoAtmEstacao() == null) {
				objviewPressao.setPressaoAtmEstacao("N/A");
			}
			if (objviewPressao.getPressaoAtmMax() == null) {
				objviewPressao.setPressaoAtmMax("N/A");
			}
			if (objviewPressao.getPressaoAtmMin() == null) {
				objviewPressao.setPressaoAtmMin("N/A");
			}
		}
		modelAndView.addObject("teste_atm", teste_atm);

		// Lista Radiacao
		List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listar(filtromodal.getEstacaoNome(),
				filtromodal.getEstacaoEstado(), Timestamp.valueOf(filtromodal.getDatahoraCaptacao()));
		for (ViewRadiacaoglobalModal objviewRadiacao : teste_radiacaoglobal) {
			if (objviewRadiacao.getRadiacaoGlobal() == null) {
				objviewRadiacao.setRadiacaoGlobal("N/A");
			}
		}
		modelAndView.addObject("teste_radiacaoglobal", teste_radiacaoglobal);

		// Lista Temperatura
		List<ViewTemperaturaModal> teste_temperatura = temperatura.listar(filtromodal.getEstacaoNome(),
				filtromodal.getEstacaoEstado(), Timestamp.valueOf(filtromodal.getDatahoraCaptacao()));
		for (ViewTemperaturaModal objviewTemperatura : teste_temperatura) {
			if (objviewTemperatura.getTemperaturaAr() == null) {
				objviewTemperatura.setTemperaturaAr("N/A");
			}
			if (objviewTemperatura.getTemperaturaMax() == null) {
				objviewTemperatura.setTemperaturaMax("N/A");
			}
			if (objviewTemperatura.getTemperaturaMin() == null) {
				objviewTemperatura.setTemperaturaMin("N/A");
			}
			if (objviewTemperatura.getTemperaturaOrvalhoMax() == null) {
				objviewTemperatura.setTemperaturaOrvalhoMax("N/A");
			}
			if (objviewTemperatura.getTemperaturaOrvalhoMin() == null) {
				objviewTemperatura.setTemperaturaOrvalhoMin("N/A");
			}
			if (objviewTemperatura.getTemperaturaPontoOrvalho() == null) {
				objviewTemperatura.setTemperaturaPontoOrvalho("N/A");
			}
		}
		modelAndView.addObject("teste_temperatura", teste_temperatura);

		// Lista Umidade
		List<ViewUmidadeModal> teste_umidade = umidade.listar(filtromodal.getEstacaoNome(),
				filtromodal.getEstacaoEstado(), Timestamp.valueOf(filtromodal.getDatahoraCaptacao()));
		for (ViewUmidadeModal objviewUmidade : teste_umidade) {
			if (objviewUmidade.getUmidadeRelativaAr() == null) {
				objviewUmidade.setUmidadeRelativaAr("N/A");
			}
			if (objviewUmidade.getUmidadeRelativaMax() == null) {
				objviewUmidade.setUmidadeRelativaMax("N/A");
			}
			if (objviewUmidade.getUmidadeRelativaMin() == null) {
				objviewUmidade.setUmidadeRelativaMin("N/A");
			}
		}	
		modelAndView.addObject("teste_umidade", teste_umidade);

		// Lista Vento
		List<ViewVentoModal> teste_vento = vento.listar(filtromodal.getEstacaoNome(), filtromodal.getEstacaoEstado(),
				Timestamp.valueOf(filtromodal.getDatahoraCaptacao()));
		for (ViewVentoModal objviewVento : teste_vento) {
			if (objviewVento.getVentoDirecaoHorario() == null) {
				objviewVento.setVentoDirecaoHorario("N/A");
			}
			if (objviewVento.getVentoRajadaMax() == null) {
				objviewVento.setVentoRajadaMax("N/A");
			}
			if (objviewVento.getVentoVelocidade() == null) {
				objviewVento.setVentoVelocidade("N/A");
			}
		}
		modelAndView.addObject("teste_vento", teste_vento);

		filtromodal.getEstacaoNome();
		filtromodal.getEstacaoEstado();
		filtromodal.getDatahoraCaptacao();
		modelAndView.addObject("filtro", filtromodal);

		// INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("index");
		return modelAndView;
	}

	// FILTRO AJAX - ESTACAO
	@RequestMapping(value = { "/filtro/ajax/{id}" }, method = RequestMethod.GET)
	public ModelAndView filtroAjax(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();

		List<ViewFiltroEstacao> teste_filtro = filtroestacaorepository.listar(id);
		modelAndView.addObject("teste_filtro", teste_filtro);

		// INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("AjaxFiltro");

		return modelAndView;

	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ModelAndView filtroMenuLateral(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(id);
		return modelAndView;
	}

	// FILTRO AJAX - ESTACAO NULO
	@RequestMapping(value = { "/filtro/ajax" }, method = RequestMethod.GET)
	public ModelAndView filtroAjaxNulo() {
		ModelAndView modelAndView = new ModelAndView();

		// INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("AjaxFiltroNulo");
		return modelAndView;
	}
}
