package com.api.BACKEND.IACIT.repository;

import java.util.List;

import com.api.BACKEND.IACIT.modal.PrecipitacaoModal;
import com.api.BACKEND.IACIT.modal.VentoModal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecipitacaoRepository extends JpaRepository<PrecipitacaoModal, Integer> {

	List<PrecipitacaoModal> findAll();
}
