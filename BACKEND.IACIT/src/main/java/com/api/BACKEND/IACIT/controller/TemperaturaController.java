package com.api.BACKEND.IACIT.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.BACKEND.IACIT.modal.TemperaturaModal;
import com.api.BACKEND.IACIT.repository.TemperaturaRepository;

@RestController
@RequestMapping("/api/temperatura")
public class TemperaturaController {
	private final TemperaturaRepository temperatura;

	public TemperaturaController(TemperaturaRepository temperatura) {
		this.temperatura = temperatura;
	}
	
	@GetMapping("/temperaturas")
	public ResponseEntity<List<TemperaturaModal>> listarTodos() {
		return ResponseEntity.ok(temperatura.findAll());
	}

}
