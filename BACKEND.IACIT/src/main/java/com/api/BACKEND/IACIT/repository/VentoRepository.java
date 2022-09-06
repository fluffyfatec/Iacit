package com.api.BACKEND.IACIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.BACKEND.IACIT.modal.VentoModal;

public interface VentoRepository extends JpaRepository<VentoModal, Integer>  {

	List<VentoModal> findAll();

}
