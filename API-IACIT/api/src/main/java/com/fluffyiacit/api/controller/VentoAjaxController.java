package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.FiltroModal;
import com.fluffyiacit.api.modal.VentoModal;
import com.fluffyiacit.api.modal.ViewVentoModal;
import com.fluffyiacit.api.repository.VentoRepository;


@Controller
@RequestMapping
public class VentoAjaxController {

    @Autowired(required = true)
    private VentoRepository ventoRepository;


    @RequestMapping(value = { "/vento" }, method = RequestMethod.GET)
    public ModelAndView telaVento() {
        ModelAndView modelAndView = new ModelAndView();

        List<ViewVentoModal> graVento = ventoRepository.listarGraphVento("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
        modelAndView.addObject("graVento", graVento);
        for (ViewVentoModal objview : graVento) {
            System.out.println("1:" + objview.getDatahoraCaptacao());
        }


        modelAndView.setViewName("Vento");
        return modelAndView;

    }

    @RequestMapping(value = { "/vento/search" }, method = RequestMethod.GET)
    public ModelAndView telaVentoFiltrada(FiltroModal filtroModal) {

        ModelAndView modelAndView = new ModelAndView();

        filtroModal.setEstacaoNome("SAO PAULO - INTERLAGOS");
        filtroModal.setEstacaoEstado("SP");
        filtroModal.setDataHoraInicial("2022-04-15 10:00:00");
        filtroModal.setDataHoraFinal("2022-04-28 10:00:00");


        if (!ventoRepository.dataLimite(Timestamp.valueOf(filtroModal.getDataHoraInicial()))) {
            System.out.println("A data inserida é inferior a primeira data presente no banco");
            modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
            modelAndView.setViewName("Vento");
            return modelAndView;
        }

        if (!ventoRepository.dataLimite(Timestamp.valueOf(filtroModal.getDataHoraFinal()))) {
            System.out.println("A data inserida é posterior a ultima data presente no banco");
            modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
            modelAndView.setViewName("Vento");
            return modelAndView;
        }


        List<ViewVentoModal> graVentoFiltro = ventoRepository.listarGraphVento(filtroModal.getEstacaoEstado(), filtroModal.getEstacaoNome(),Timestamp.valueOf(filtroModal.getDataHoraInicial()),Timestamp.valueOf(filtroModal.getDataHoraFinal()));
        modelAndView.addObject("graVentoFiltro", graVentoFiltro);
        for (ViewVentoModal objview : graVentoFiltro) {
            System.out.println("1:" + objview.getDatahoraCaptacao());
        }



        modelAndView.setViewName("Vento");
        return modelAndView;

    }


}
