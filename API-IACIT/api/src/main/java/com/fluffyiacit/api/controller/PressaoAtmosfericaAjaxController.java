//package com.fluffyiacit.api.controller;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.fluffyiacit.api.modal.FiltroModal;
//import com.fluffyiacit.api.modal.PressaoAtmosfericaModal;
//import com.fluffyiacit.api.modal.ViewPressaoAtmModal;
//import com.fluffyiacit.api.repository.PressaoAtmRepository;
//
//
//@Controller
//@RequestMapping
//public class PressaoAtmosfericaAjaxController {
//
//    @Autowired(required = true)
//    private PressaoAtmRepository pressaoAtmRepository;
//
//
//    @RequestMapping(value = { "/pressao" }, method = RequestMethod.GET)
//    public ModelAndView telaPressaoAtm() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<ViewPressaoAtmModal> graPressaoAtm = pressaoAtmRepository.listarGraphPressao("SP", "SAO PAULO - INTERLAGOS",Timestamp.valueOf("2022-06-28 10:00:00"),Timestamp.valueOf("2022-07-01 10:00:00"));
//        modelAndView.addObject("graPressaoAtm", graPressaoAtm);
//        for (ViewPressaoAtmModal objview : graPressaoAtm) {
//            System.out.println("1:" + objview.getDatahoraCaptacao());
//        }
//
//
//        modelAndView.setViewName("PressaoAtm");
//        return modelAndView;
//
//    }
//
//    @RequestMapping(value = { "/pressaoAtm/search" }, method = RequestMethod.GET)
//    public ModelAndView telaPressaoAtmFiltrada(FiltroModal filtroModal) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        filtroModal.setEstacaoNome("SAO PAULO - INTERLAGOS");
//        filtroModal.setEstacaoEstado("SP");
//        filtroModal.setDataHoraInicial("2022-04-15 10:00:00");
//        filtroModal.setDataHoraFinal("2022-04-28 10:00:00");
//
//
//        if (!pressaoAtmRepository.dataLimite(Timestamp.valueOf(filtroModal.getDataHoraInicial()))) {
//            System.out.println("A data inserida é inferior a primeira data presente no banco");
//            modelAndView.addObject("dataLimiteInicial", "A data inserida é inferior a primeira data presente no banco");
//            modelAndView.setViewName("PressaoAtm");
//            return modelAndView;
//        }
//
//        if (!pressaoAtmRepository.dataLimite(Timestamp.valueOf(filtroModal.getDataHoraFinal()))) {
//            System.out.println("A data inserida é posterior a ultima data presente no banco");
//            modelAndView.addObject("dataLimiteFinal", "A data inserida é posterior a última data presente no banco");
//            modelAndView.setViewName("PressaoAtm");
//            return modelAndView;
//        }
//
//
//        List<ViewPressaoAtmModal> graPressaoAtmFiltro = pressaoAtmRepository.listarGraphPressao(filtroModal.getEstacaoEstado(), filtroModal.getEstacaoNome(),Timestamp.valueOf(filtroModal.getDataHoraInicial()),Timestamp.valueOf(filtroModal.getDataHoraFinal()));
//        modelAndView.addObject("graPressaoAtmFiltro", graPressaoAtmFiltro);
//        for (ViewPressaoAtmModal objview : graPressaoAtmFiltro) {
//            System.out.println("1:" + objview.getDatahoraCaptacao());
//        }
//
//
//
//        modelAndView.setViewName("PressaoAtm");
//        return modelAndView;
//
//    }
//
//
//}
