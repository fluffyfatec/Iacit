package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.RadiacaoGlobalModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.repository.RadiacaoGlobalRepository;

import DTO.FiltroDatasDTO;


@Controller
@RequestMapping
public class RadiacaoGlobalAjaxController {

    @Autowired(required = true)
    private RadiacaoGlobalRepository radiacaoGlobalRepository;


    @RequestMapping(value = { "/radiacao" }, method = RequestMethod.GET)
    public ModelAndView telaRadiacao() {
        ModelAndView modelAndView = new ModelAndView();

        List<ViewRadiacaoglobalModal> graRadiacao = radiacaoGlobalRepository.listRange("SP", "SAO PAULO - INTERLAGOS", Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
        modelAndView.addObject("graRadiacao", graRadiacao);
        for (ViewRadiacaoglobalModal objview : graRadiacao) {
            System.out.println("1:" + objview.getDatahoraCaptacao());
        }


        modelAndView.setViewName("Radiacao");
        return modelAndView;

    }

    @RequestMapping(value = { "/radiacao/search" }, method = RequestMethod.GET)
    public ModelAndView telaRadiacaoFiltrada(FiltroDatasDTO filtroDatasDto) {

        ModelAndView modelAndView = new ModelAndView();

        filtroDatasDto.setEstacaoNome("SAO PAULO - INTERLAGOS");
        filtroDatasDto.setEstacaoEstado("SP");
        filtroDatasDto.setDataHoraInicial("2022-04-15 10:00:00");
        filtroDatasDto.setDataHoraFinal("2022-04-28 10:00:00");


        if (!radiacaoGlobalRepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()))) {
            System.out.println("A data inserida é inferior a primeira data presente no banco");
            modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
            modelAndView.setViewName("Radiacao");
            return modelAndView;
        }

        if (!radiacaoGlobalRepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()))) {
            System.out.println("A data inserida é posterior a ultima data presente no banco");
            modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
            modelAndView.setViewName("Radiacao");
            return modelAndView;
        }


        List<ViewRadiacaoglobalModal> graRadiacaoFiltro = radiacaoGlobalRepository.listRange(filtroDatasDto.getEstacaoEstado(), filtroDatasDto.getEstacaoNome(),Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()),Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()));
        modelAndView.addObject("graRadiacaoFiltro", graRadiacaoFiltro);
        for (ViewRadiacaoglobalModal objview : graRadiacaoFiltro) {
            System.out.println("1:" + objview.getDatahoraCaptacao());
        }



        modelAndView.setViewName("Radiacao");
        return modelAndView;

    }


}
