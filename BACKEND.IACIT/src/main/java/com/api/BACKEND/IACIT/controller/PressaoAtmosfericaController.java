package com.api.BACKEND.IACIT.controller;

import java.util.List;

import com.api.BACKEND.IACIT.modal.PrecipitacaoModal;
import com.api.BACKEND.IACIT.repository.PrecipitacaoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pressao")
public class PressaoAtmosfericaController {

	private final PrecipitacaoRepository pressaoAtmosferica;

	public PressaoAtmosfericaController(PrecipitacaoRepository pressaoAtmosferica) {
		this.pressaoAtmosferica = pressaoAtmosferica;
	}
	@GetMapping("/pressoesatmosfericas")
	public ResponseEntity<List<PrecipitacaoModal>> listarTodos() {
		return ResponseEntity.ok(pressaoAtmosferica.findAll());
	
	}
}
