package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import com.fluffyiacit.api.repository.TemperaturaRepository;

import DTO.FiltroDatasDTO;


@Controller
@RequestMapping
public class TemperaturaAjaxController {

    @Autowired(required = true)
    private TemperaturaRepository temperaturaRepository;


    @RequestMapping(value = { "/Temperatura/{estRegiao}/{estNome}/{estEstado}/{estDTinicial}/{estDTfinal}" }, method = RequestMethod.GET)
    public ModelAndView telaTemperatura(@PathVariable("estRegiao") String estRegiao,
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
        
        List<ViewTemperaturaModal> rangeTemperatura = temperaturaRepository.listRange(estEstado, estNome,Timestamp.valueOf(estDTinicial),Timestamp.valueOf(estDTfinal));
        modelAndView.addObject("rangeTemperatura", rangeTemperatura);
        
        //for (ViewTemperaturaModal objview : rangeTemperatura) {
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

        modelAndView.setViewName("Temperatura");
        return modelAndView;

    }
   
    
    

    @RequestMapping(value = { "/temperatura/search" }, method = RequestMethod.GET)
    public ModelAndView telaTemperaturaFiltrada(DTO.FiltroDatasDTO filtroDatasDto) {

        ModelAndView modelAndView = new ModelAndView();

        filtroDatasDto.setEstacaoNome("SAO PAULO - INTERLAGOS");
        filtroDatasDto.setEstacaoEstado("SP");
        filtroDatasDto.setDataHoraInicial("2022-04-15 10:00:00");
        filtroDatasDto.setDataHoraFinal("2022-04-28 10:00:00");


        if (!temperaturaRepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()))) {
            System.out.println("A data inserida é inferior a primeira data presente no banco");
            modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
            modelAndView.setViewName("Temperatura");
            return modelAndView;
        }

        if (!temperaturaRepository.dataLimite(Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()))) {
            System.out.println("A data inserida é posterior a ultima data presente no banco");
            modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
            modelAndView.setViewName("Temperatura");
            return modelAndView;
        }


        List<ViewTemperaturaModal> graTemperaturaFiltro = temperaturaRepository.listRange(filtroDatasDto.getEstacaoEstado(), filtroDatasDto.getEstacaoNome(),Timestamp.valueOf(filtroDatasDto.getDataHoraInicial()),Timestamp.valueOf(filtroDatasDto.getDataHoraFinal()));
        modelAndView.addObject("graTemperaturaFiltro", graTemperaturaFiltro);
        for (ViewTemperaturaModal objview : graTemperaturaFiltro) {
            //System.out.println("1:" + objview.getDatahoraCaptacao());
        }



        modelAndView.setViewName("Temperatura");
        return modelAndView;

    }

}
