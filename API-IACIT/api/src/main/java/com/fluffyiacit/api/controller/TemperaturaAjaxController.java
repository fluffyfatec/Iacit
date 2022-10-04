//package com.fluffyiacit.api.controller;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import com.fluffyiacit.api.modal.FiltroModal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.fluffyiacit.api.modal.TemperaturaModal;
//import com.fluffyiacit.api.modal.ViewTemperaturaModal;
//import com.fluffyiacit.api.repository.TemperaturaRepository;
//
//
//@Controller
//@RequestMapping
//public class TemperaturaAjaxController {
//
//    @Autowired(required = true)
//    private TemperaturaRepository temperaturaRepository;
//
//
//    @RequestMapping(value = { "/temperatura" }, method = RequestMethod.GET)
//    public ModelAndView telaTemperatura() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<ViewTemperaturaModal> graTemperatura = temperaturaRepository.listarGraphTemperatura("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
//        modelAndView.addObject("graTemperatura", graTemperatura);
//        for (ViewTemperaturaModal objview : graTemperatura) {
//            System.out.println("1:" + objview.getDatahoraCaptacao());
//        }
//
//
//        modelAndView.setViewName("Temperatura");
//        return modelAndView;
//
//    }
//
//    @RequestMapping(value = { "/temperatura/search" }, method = RequestMethod.GET)
//    public ModelAndView telaTemperaturaFiltrada(FiltroModal filtroModal) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        filtroModal.setEstacaoNome("SAO PAULO - INTERLAGOS");
//        filtroModal.setEstacaoEstado("SP");
//        filtroModal.setDataHoraInicial("2022-04-15 10:00:00");
//        filtroModal.setDataHoraFinal("2022-04-28 10:00:00");
//
//
//        if (!temperaturaRepository.dataLimite(Timestamp.valueOf(filtroModal.getDataHoraInicial()))) {
//            System.out.println("A data inserida é inferior a primeira data presente no banco");
//            modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
//            modelAndView.setViewName("Temperatura");
//            return modelAndView;
//        }
//
//        if (!temperaturaRepository.dataLimite(Timestamp.valueOf(filtroModal.getDataHoraFinal()))) {
//            System.out.println("A data inserida é posterior a ultima data presente no banco");
//            modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
//            modelAndView.setViewName("Temperatura");
//            return modelAndView;
//        }
//
//
//        List<ViewTemperaturaModal> graTemperaturaFiltro = temperaturaRepository.listarGraphTemperatura(filtroModal.getEstacaoEstado(), filtroModal.getEstacaoNome(),Timestamp.valueOf(filtroModal.getDataHoraInicial()),Timestamp.valueOf(filtroModal.getDataHoraFinal()));
//        modelAndView.addObject("graTemperaturaFiltro", graTemperaturaFiltro);
//        for (ViewTemperaturaModal objview : graTemperaturaFiltro) {
//            System.out.println("1:" + objview.getDatahoraCaptacao());
//        }
//
//
//
//        modelAndView.setViewName("Temperatura");
//        return modelAndView;
//
//    }
//
//}
