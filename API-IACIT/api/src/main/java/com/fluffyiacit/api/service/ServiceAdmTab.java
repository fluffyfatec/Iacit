package com.fluffyiacit.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewFiltroEstacaoTab;
import com.fluffyiacit.api.repository.EstacaoTabRepository;

@Service
public class ServiceAdmTab {

	    @Autowired 
	    EstacaoTabRepository estacaotabrepository;

	    public ModelAndView listar(ViewFiltroEstacaoTab bbb) {
	    	ModelAndView moden = new ModelAndView();
	    	List<ViewFiltroEstacaoTab> aaa = estacaotabrepository.listar(bbb.getEstacaoNome());
	    	moden.setViewName("UsuarioUpEst");
	    	moden.addObject("estacaoAtiva", aaa);
	 		return moden;
	    }
	  
	      
	 }
	                

	