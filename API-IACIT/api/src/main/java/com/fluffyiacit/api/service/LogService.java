package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.LogUsuarioModal;
import com.fluffyiacit.api.repository.LogRepository;

import DTO.LogUsuarioDTO;

@Service
public class LogService {

	    @Autowired 
	    LogRepository logrep;

	    public ModelAndView listar(LogUsuarioDTO logusuario) {
	    	ModelAndView  moden= new ModelAndView();
	    	LogUsuarioModal logAtiva = logrep.findByLogCodUsuario(logusuario.getLogCodUsuario());
	 
	        moden.addObject("estacaoAtiva", logAtiva);
	 		moden.setViewName("UsuarioUpEst");
	 		
	 		return moden;
	    }
	      
	 }
	                

	