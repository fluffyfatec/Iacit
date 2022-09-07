package com.api.BACKEND.IACIT.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.BACKEND.IACIT.modal.EstacaoModal;
import com.api.BACKEND.IACIT.repository.EstacaoRepository;

@RestController
@RequestMapping("/api/estacao")
public class EstacaoController {
	private final EstacaoRepository estacao;

	public EstacaoController(EstacaoRepository estacao) {
		this.estacao = estacao;
	}
	
	@GetMapping("/estacoes")
	public ResponseEntity<List<EstacaoModal>> listarTodos(){
		return ResponseEntity.ok(estacao.findAll());
	}
	
	
	
	
	

}
