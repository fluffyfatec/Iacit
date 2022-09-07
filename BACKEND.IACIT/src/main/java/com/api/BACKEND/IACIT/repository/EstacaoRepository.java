package com.api.BACKEND.IACIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.BACKEND.IACIT.modal.EstacaoModal;

public interface EstacaoRepository extends JpaRepository<EstacaoModal, String>{
	List<EstacaoModal> findAll();

}
