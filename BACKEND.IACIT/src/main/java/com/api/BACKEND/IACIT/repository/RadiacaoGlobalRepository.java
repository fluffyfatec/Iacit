package com.api.BACKEND.IACIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.BACKEND.IACIT.modal.EstacaoModal;
import com.api.BACKEND.IACIT.modal.RadiacaoGlobalModal;

public interface RadiacaoGlobalRepository extends JpaRepository<RadiacaoGlobalModal, String>{
	List<RadiacaoGlobalModal> findAll();
}
