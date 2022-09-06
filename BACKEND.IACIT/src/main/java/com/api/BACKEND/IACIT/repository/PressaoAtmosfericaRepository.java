package com.api.BACKEND.IACIT.repository;

import java.util.List;

import com.api.BACKEND.IACIT.modal.PressaoAtmosfericaModal;
import com.api.BACKEND.IACIT.modal.VentoModal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PressaoAtmosfericaRepository extends JpaRepository<PressaoAtmosfericaModal, Integer>{
	
	List<PressaoAtmosfericaModal> findAll();

}
