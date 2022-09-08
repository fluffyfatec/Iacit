package com.api.BACKEND.IACIT.repository;

import java.util.List;

import com.api.BACKEND.IACIT.modal.TemperaturaModal;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TemperaturaRepository extends JpaRepository<TemperaturaModal, String>{
	List<TemperaturaModal> findAll();
}
