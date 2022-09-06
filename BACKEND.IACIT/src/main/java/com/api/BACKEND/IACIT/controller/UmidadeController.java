package com.api.BACKEND.IACIT.controller;

import java.util.List;

import com.api.BACKEND.IACIT.modal.UmidadeModal;
import com.api.BACKEND.IACIT.modal.VentoModal;
import com.api.BACKEND.IACIT.repository.UmidadeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/umidade")
public class UmidadeController {

	private final UmidadeRepository umidade;

	public UmidadeController(UmidadeRepository umidade) {
		this.umidade = umidade;
	}
	
	@GetMapping("/umidades")
	public ResponseEntity<List<UmidadeModal>> listarTodos() {
		return ResponseEntity.ok(umidade.findAll());
	}
}