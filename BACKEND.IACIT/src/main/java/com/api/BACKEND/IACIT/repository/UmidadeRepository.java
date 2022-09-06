package com.api.BACKEND.IACIT.repository;

import java.util.List;

import com.api.BACKEND.IACIT.modal.UmidadeModal;
import com.api.BACKEND.IACIT.modal.VentoModal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UmidadeRepository extends JpaRepository<UmidadeModal, Integer> {

	List<UmidadeModal> findAll();


}
