package com.api.BACKEND.IACIT.controller;

import java.util.List;

import com.api.BACKEND.IACIT.modal.PrecipitacaoModal;
import com.api.BACKEND.IACIT.modal.VentoModal;
import com.api.BACKEND.IACIT.repository.PrecipitacaoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/precipitacao")
public class PrecipitacaoController {

	private final PrecipitacaoRepository precipitacao;

	public PrecipitacaoController(PrecipitacaoRepository precipitacao) {
		this.precipitacao = precipitacao;
	}
	@GetMapping("/precipitacoes")
	public ResponseEntity<List<PrecipitacaoModal>> listarTodos() {
		return ResponseEntity.ok(precipitacao.findAll());
	}
	
}
