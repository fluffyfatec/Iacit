package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.repository.UmidadeRepository;

import DTO.FiltroDatasDTO;

@Controller
@RequestMapping
public class UmidadeAjaxController {

	@Autowired(required = true)
	private UmidadeRepository umidaderepository;

	@RequestMapping(value = { "/Umidade/{estRegiao}/{estNome}/{estEstado}/{estDTinicial}/{estDTfinal}" }, method = RequestMethod.GET)
	public ModelAndView telaUmidade(@PathVariable("estRegiao") String estRegiao,
                                    @PathVariable("estNome") String estNome,
                                    @PathVariable("estEstado") String estEstado, 
                                    @PathVariable("estDTinicial") String estDTinicial, 
                                    @PathVariable("estDTfinal") String estDTfinal
                                    ) {
		ModelAndView modelAndView = new ModelAndView();
		FiltroDatasDTO filtrodatas = new FiltroDatasDTO();
        
        estRegiao = estRegiao.replace('*', ' ');
        estNome = estNome.replace('*', ' ');
        estEstado = estEstado.replace('*', ' ');
        estDTinicial = estDTinicial.replace('*', ' ');
        estDTfinal = estDTfinal.replace('*', ' ');

		List<ViewUmidadeModal> rangeUmidade = umidaderepository.listRange(estEstado, estNome,Timestamp.valueOf(estDTinicial),Timestamp.valueOf(estDTfinal));
				
		modelAndView.addObject("rangeUmidade", rangeUmidade);
		//for (ViewUmidadeModal objview : rangeUmidade) {
			//System.out.println("1:" + objview.getDatahoraCaptacao());
		//}
		filtrodatas.setEstacaoRegiao(estRegiao);
        filtrodatas.setEstacaoNome(estEstado);
        filtrodatas.setEstacaoEstado(estNome);
        filtrodatas.setCodWmo("");
        filtrodatas.setDataHoraInicial(estDTinicial);
        filtrodatas.setDataHoraFinal(estDTfinal);
        modelAndView.addObject("filtro", filtrodatas);
        
//        System.out.println("1:" + estRegiao);
//        System.out.println("2:" + estNome);
//        System.out.println("3:" + estEstado);
//        System.out.println("4:" + estDTinicial);
//        System.out.println("5:" + estDTfinal);
	        
		modelAndView.setViewName("Umidade");
		return modelAndView;
	}

	@RequestMapping(value = { "/Umidade/search" }, method = RequestMethod.GET)
	public ModelAndView telaUmidadeFiltrada(FiltroDatasDTO filtroDatasDto) {

		ModelAndView modelAndView = new ModelAndView();

		filtroDatasDto.setEstacaoNome("SAO PAULO - INTERLAGOS");
		filtroDatasDto.setEstacaoEstado("SP");
		filtroDatasDto.setDataHoraInicial("2022-04-15 10:00:00");
		filtroDatasDto.setDataHoraFinal("2022-04-28 10:00:00");

		if (!umidaderepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()))) {
			System.out.println("A data inserida é inferior a primeira data presente no banco");
			modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
			modelAndView.setViewName("Umidade");
			return modelAndView;
		}

		if (!umidaderepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()))) {
			System.out.println("A data inserida é posterior a ultima data presente no banco");
			modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
			modelAndView.setViewName("Umidade");
			return modelAndView;
		}

		List<ViewUmidadeModal> rangeUmidade = umidaderepository.listRange(filtroDatasDto.getEstacaoEstado(),
				filtroDatasDto.getEstacaoNome(), Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()),
				Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()));
		modelAndView.addObject("rangeUmidade", rangeUmidade);
		for (ViewUmidadeModal objview : rangeUmidade) {
			//System.out.println("1:" + objview.getDatahoraCaptacao());
		}

		modelAndView.setViewName("Umidade");
		return modelAndView;

	}

}
