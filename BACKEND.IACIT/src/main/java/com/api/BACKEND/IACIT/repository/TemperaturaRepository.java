package com.api.BACKEND.IACIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.BACKEND.IACIT.modal.RadiacaoGlobalModal;
import com.api.BACKEND.IACIT.modal.TemperaturaModal;

public interface TemperaturaRepository extends JpaRepository<TemperaturaModal, String>{
	List<TemperaturaModal> findAll();
}
