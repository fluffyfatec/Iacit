package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.EstacaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.EstacaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;

import DTO.EstacaoDTO;
import DTO.LoginSessao;

@Service
public class ServiceAdm {

	    @Autowired 
	    EstacaoRepository estacaorep;
	   
		@Autowired
		UsuarioRepository usuarioRepository;

	    public ModelAndView update(EstacaoDTO estacao, LoginSessao sessao) {
	    	ModelAndView  moden= new ModelAndView();
	    	EstacaoModal estacaoAtiva = estacaorep.findByEstacaoNome(estacao.getEstacaoNome());
	    	UsuarioModal userAdmin = usuarioRepository.findByUsuarioUsername(sessao.getUsuario());
	        estacaoAtiva.setEstacaoStatus(estacao.getEstacaoStatus());
	        estacaoAtiva.setUsuarioAlterou(userAdmin);
	        estacaorep.save(estacaoAtiva);
	        moden.addObject("sessao", sessao);
	 		moden.setViewName("HfefCadUsuario");
	 		return moden;
	    }
	  
	    public ModelAndView listar(EstacaoDTO estacao) {
	    	ModelAndView  moden= new ModelAndView();
	    	EstacaoModal estacaoAtiva = estacaorep.findByEstacaoNome(estacao.getEstacaoNome());
	 
	        moden.addObject("estacaoAtiva", estacaoAtiva);
	 		moden.setViewName("UsuarioUpEst");
	 		
	 		return moden;
	    }
	      
	 }
	                

	