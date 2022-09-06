package com.api.BACKEND.IACIT.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.BACKEND.IACIT.modal.VentoModal;
import com.api.BACKEND.IACIT.repository.VentoRepository;

@RestController
@RequestMapping("/api/vento")
public class VentoController {

	private final VentoRepository vento;

	public VentoController(VentoRepository vento) {
		this.vento = vento;
	}

	@GetMapping("/ventos")
	public ResponseEntity<List<VentoModal>> listarTodos() {
		return ResponseEntity.ok(vento.findAll());
	}

}
