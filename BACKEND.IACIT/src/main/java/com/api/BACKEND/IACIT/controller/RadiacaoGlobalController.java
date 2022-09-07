package com.api.BACKEND.IACIT.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.BACKEND.IACIT.modal.RadiacaoGlobalModal;
import com.api.BACKEND.IACIT.repository.RadiacaoGlobalRepository;

@RestController
@RequestMapping("/api/radiacao")
public class RadiacaoGlobalController {

	private final RadiacaoGlobalRepository radiacaoGlobal;

	public RadiacaoGlobalController (RadiacaoGlobalRepository radiacaoGlobal) {
		this.radiacaoGlobal = radiacaoGlobal;
	}
	@GetMapping("/radiacaoglobal")
	public ResponseEntity<List<RadiacaoGlobalModal>> listarTodos() {
		return ResponseEntity.ok(radiacaoGlobal.findAll());
	
	}
}
