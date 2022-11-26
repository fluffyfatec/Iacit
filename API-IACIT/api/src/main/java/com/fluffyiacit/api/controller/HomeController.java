package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewFiltroEstacao;
import com.fluffyiacit.api.modal.ViewFiltroRegiao;
import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.modal.ViewVentoModal;
import com.fluffyiacit.api.repository.FiltroEstacaoRepository;
import com.fluffyiacit.api.repository.FiltroRegiaoRepository;
import com.fluffyiacit.api.repository.PrecipitacaoRepository;
import com.fluffyiacit.api.repository.PressaoAtmRepository;
import com.fluffyiacit.api.repository.RadiacaoGlobalRepository;
import com.fluffyiacit.api.repository.TemperaturaRepository;
import com.fluffyiacit.api.repository.UmidadeRepository;
import com.fluffyiacit.api.repository.VentoRepository;

import DTO.FiltroDatasDTO;

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
	
	@Autowired(required = true)
	private FiltroRegiaoRepository filtroRegiaoRepository;
	
	

	// ENTRAR PAGINA INDEX
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView PaginaIndex() {
		ModelAndView modelAndView = new ModelAndView();
		FiltroDatasDTO filtrodatas = new FiltroDatasDTO();

		filtrodatas.setEstacaoRegiao("SE");
		filtrodatas.setEstacaoNome("SP");
		filtrodatas.setEstacaoEstado("SAO PAULO - INTERLAGOS");
		filtrodatas.setCodWmo("");
		filtrodatas.setDataHoraInicial("2022-06-27 10:00:00");
		filtrodatas.setDataHoraFinal("2022-06-28 10:00:00");
		filtrodatas.setPagina("nulo");
		modelAndView.addObject("filtro", filtrodatas);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// LISTA RANGE//

		// Lista Precipitacao
		List<ViewPrecipitacaoModal> rangePrecipitacao = precipitacao.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPrecipitacaoModal objviewPrecipitacao : rangePrecipitacao) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
		}
		modelAndView.addObject("rangePrecipitacao", rangePrecipitacao);

		// Lista Pressao
		List<ViewPressaoAtmModal> rangeAtm = pressao.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPressaoAtmModal objviewPressao : rangeAtm) {
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
		modelAndView.addObject("rangeAtm", rangeAtm);

		// Lista Radiacao
		List<ViewRadiacaoglobalModal> rangeRadiacaoglobal = radiacao.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewRadiacaoglobalModal objviewRadiacao : rangeRadiacaoglobal) {
			if (objviewRadiacao.getRadiacaoGlobal() == null) {
				objviewRadiacao.setRadiacaoGlobal("N/A");
			}
		}
		modelAndView.addObject("rangeRadiacaoglobal", rangeRadiacaoglobal);

		// Lista Temperatura
		List<ViewTemperaturaModal> rangeTemperatura = temperatura.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewTemperaturaModal objviewTemperatura : rangeTemperatura) {
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
		modelAndView.addObject("rangeTemperatura", rangeTemperatura);
		

		// Lista Umidade
		List<ViewUmidadeModal> rangeUmidade = umidade.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewUmidadeModal objviewUmidade : rangeUmidade) {
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
		modelAndView.addObject("rangeUmidade", rangeUmidade);

		// Lista Vento
		List<ViewVentoModal> rangeVento = vento.listRange(filtrodatas.getEstacaoNome(), filtrodatas.getEstacaoEstado(),
				Timestamp.valueOf(filtrodatas.getDataHoraInicial()), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewVentoModal objviewVento : rangeVento) {
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
		modelAndView.addObject("rangeVento", rangeVento);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// LISTA UNICA//

		// Lista Precipitacao
		List<ViewPrecipitacaoModal> teste_precipitacao = precipitacao.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPrecipitacaoModal objviewPrecipitacao : teste_precipitacao) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
		}
		modelAndView.addObject("unicaPrecipitacao", teste_precipitacao);

		// Lista Pressao
		List<ViewPressaoAtmModal> teste_atm = pressao.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
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
		modelAndView.addObject("unicaAtm", teste_atm);

		// Lista Radiacao
		List<ViewRadiacaoglobalModal> teste_radiacaoglobal = radiacao.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewRadiacaoglobalModal objviewRadiacao : teste_radiacaoglobal) {
			if (objviewRadiacao.getRadiacaoGlobal() == null) {
				objviewRadiacao.setRadiacaoGlobal("N/A");
			}
		}
		modelAndView.addObject("unicaRadiacaoglobal", teste_radiacaoglobal);

		// Lista Temperatura
		List<ViewTemperaturaModal> teste_temperatura = temperatura.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
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
		modelAndView.addObject("unicaTemperatura", teste_temperatura);

		// Lista Umidade
		List<ViewUmidadeModal> teste_umidade = umidade.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
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
		modelAndView.addObject("unicaUmidade", teste_umidade);

		// Lista Vento
		List<ViewVentoModal> teste_vento = vento.listUnica(filtrodatas.getEstacaoNome(), filtrodatas.getEstacaoEstado(),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
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
		modelAndView.addObject("unicaVento", teste_vento);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("index");
		return modelAndView;
		//
	}

	// ENTRAR PAGINA INDEX FILTRADA
	@RequestMapping(value = { "/index" }, method = RequestMethod.POST)
	public ModelAndView PaginaIndexFiltrada(FiltroDatasDTO filtrodatas) {
		ModelAndView modelAndView = new ModelAndView();

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// LISTA RANGE//

		// Lista Precipitacao
		List<ViewPrecipitacaoModal> rangePrecipitacao = precipitacao.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPrecipitacaoModal objviewPrecipitacao : rangePrecipitacao) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
			
				    
		}
		modelAndView.addObject("rangePrecipitacao", rangePrecipitacao);
		Map<String, String> result = rangePrecipitacao.stream().collect
				  (Collectors.toMap(ViewPrecipitacaoModal::getEstacaoNome ,ViewPrecipitacaoModal::getPrecipitacaototal, (key1, key2)-> key2));
	        
		System.out.println("map: " + result);
	

		// Lista Pressao
		List<ViewPressaoAtmModal> rangeAtm = pressao.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPressaoAtmModal objviewPressao : rangeAtm) {
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
		modelAndView.addObject("rangeAtm", rangeAtm);
		
		// Lista Radiacao
		List<ViewRadiacaoglobalModal> rangeRadiacaoglobal = radiacao.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewRadiacaoglobalModal objviewRadiacao : rangeRadiacaoglobal) {
			if (objviewRadiacao.getRadiacaoGlobal() == null) {
				objviewRadiacao.setRadiacaoGlobal("N/A");
			}
		}
		modelAndView.addObject("rangeRadiacaoglobal", rangeRadiacaoglobal);
		/*Map<String, Timestamp> mapRadiacao = rangeRadiacaoglobal.stream().collect
				  (Collectors.toMap(ViewRadiacaoglobalModal::getEstacaoNome ,ViewRadiacaoglobalModal::getDatahoraCaptacao, (key1, key2)-> key2));*/
	        
		//System.out.println("map: " + mapRadiacao );

		// Lista Temperatura
		List<ViewTemperaturaModal> rangeTemperatura = temperatura.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewTemperaturaModal objviewTemperatura : rangeTemperatura) {
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
		modelAndView.addObject("rangeTemperatura", rangeTemperatura);

		// Lista Umidade
		List<ViewUmidadeModal> rangeUmidade = umidade.listRange(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraInicial()),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewUmidadeModal objviewUmidade : rangeUmidade) {
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
		modelAndView.addObject("rangeUmidade", rangeUmidade);

		// Lista Vento
		List<ViewVentoModal> rangeVento = vento.listRange(filtrodatas.getEstacaoNome(), filtrodatas.getEstacaoEstado(),
				Timestamp.valueOf(filtrodatas.getDataHoraInicial()), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewVentoModal objviewVento : rangeVento) {
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
		modelAndView.addObject("rangeVento", rangeVento);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// LISTA UNICA//

		// Lista Precipitacao
		List<ViewPrecipitacaoModal> unicaPrecipitacao = precipitacao.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPrecipitacaoModal objviewPrecipitacao : unicaPrecipitacao) {
			if (objviewPrecipitacao.getPrecipitacaototal() == null) {
				objviewPrecipitacao.setPrecipitacaototal("N/A");
			}
		}
		modelAndView.addObject("unicaPrecipitacao", unicaPrecipitacao);

		// Lista Pressao
		List<ViewPressaoAtmModal> unicaAtm = pressao.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewPressaoAtmModal objviewPressao : unicaAtm) {
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
		modelAndView.addObject("unicaAtm", unicaAtm);

		// Lista Radiacao
		List<ViewRadiacaoglobalModal> unicaRadiacaoglobal = radiacao.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewRadiacaoglobalModal objviewRadiacao : unicaRadiacaoglobal) {
			if (objviewRadiacao.getRadiacaoGlobal() == null) {
				objviewRadiacao.setRadiacaoGlobal("N/A");
			}
		}
		modelAndView.addObject("unicaRadiacaoglobal", unicaRadiacaoglobal);

		// Lista Temperatura
		List<ViewTemperaturaModal> unicaTemperatura = temperatura.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewTemperaturaModal objviewTemperatura : unicaTemperatura) {
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
		modelAndView.addObject("unicaTemperatura", unicaTemperatura);

		// Lista Umidade
		List<ViewUmidadeModal> unicaUmidade = umidade.listUnica(filtrodatas.getEstacaoNome(),
				filtrodatas.getEstacaoEstado(), Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewUmidadeModal objviewUmidade : unicaUmidade) {
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
		modelAndView.addObject("unicaUmidade", unicaUmidade);

		// Lista Vento
		List<ViewVentoModal> unicaVento = vento.listUnica(filtrodatas.getEstacaoNome(), filtrodatas.getEstacaoEstado(),
				Timestamp.valueOf(filtrodatas.getDataHoraFinal()));
		for (ViewVentoModal objviewVento : unicaVento) {
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
		modelAndView.addObject("unicaVento", unicaVento);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// FILTROS DE DADOS
	    filtrodatas.getEstacaoRegiao();
		filtrodatas.getEstacaoNome();
		filtrodatas.getEstacaoEstado();
		filtrodatas.getDataHoraInicial();
		filtrodatas.getDataHoraFinal();
		filtrodatas.setPagina("/index");
		modelAndView.addObject("filtro", filtrodatas);

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
	// FILTRO AJAX - REGIAO
		@RequestMapping(value = { "/ajax/filtro/{id}" }, method = RequestMethod.GET)
		public ModelAndView filtrRegiao(@PathVariable("id") String id) {
			ModelAndView modelAndView = new ModelAndView();
			
			List<ViewFiltroRegiao> filtroRegiao = filtroRegiaoRepository.listar(id);
			modelAndView.addObject("filtroRegiao", filtroRegiao);

			//INFORMANDO A PAGINA QUE SERA MOSTRADA
			modelAndView.setViewName("AjaxFiltroRegiao");
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

	
	   @RequestMapping(value = { "/telausuario" }, method = RequestMethod.GET)
	    public ModelAndView telaPrecipitacao() {
	        
	        ModelAndView modelAndView = new ModelAndView();
	        
	        modelAndView.setViewName("UsuarioHome");
	        return modelAndView;

	    }



}
