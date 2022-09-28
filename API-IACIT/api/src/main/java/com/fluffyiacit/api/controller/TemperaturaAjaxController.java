package com.fluffyiacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.TemperaturaModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;
import com.fluffyiacit.api.repository.TemperaturaRepository;


@Controller
@RequestMapping
public class TemperaturaAjaxController {

    @Autowired(required = true)
    private TemperaturaRepository temperaturaRepository;


    @RequestMapping(value = { "/temperatura" }, method = RequestMethod.GET)
    public ModelAndView filtroMenuLateral() {
        ModelAndView modelAndView = new ModelAndView();

        List<ViewTemperaturaModal> graTemperatura = temperaturaRepository.listarGraphTemperatura("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
        modelAndView.addObject("graTemperatura", graTemperatura);
        for (ViewTemperaturaModal objview : graTemperatura) {
            System.out.println("1:" + objview.getDatahoraCaptacao());
        }


        modelAndView.setViewName("Temperatura");
        return modelAndView;

    }


}
