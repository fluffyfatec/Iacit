package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.EstacaoModal;
import com.fluffyiacit.api.repository.EstacaoRepository;

import DTO.EstacaoDTO;

@Service
public class ServiceAdm {

	    @Autowired 
	    EstacaoRepository estacaorep;

	    public ModelAndView update(EstacaoDTO estacao ) {
	    	ModelAndView  moden= new ModelAndView();
	    	EstacaoModal estacaoAtiva = estacaorep.findByEstacaoNomeAndEstacaoEstado(estacao.getEstacaoNome(), estacao.getEstacaoEstado());
	        estacaoAtiva.setEstacaoStatus(estacao.getEstacaoStatus());
	        estacaorep.save(estacaoAtiva);
	        moden.addObject("colocar o nome do retorno", estacao);
	 		moden.setViewName("trocar o nome do html aqui");
	 		
	 		return moden;
	    }
	  
	      
	 }
	                

	