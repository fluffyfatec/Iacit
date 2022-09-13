package com.fluffyiacit.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluffyiacit.api.modal.VentoModal;

public interface VentoRepository   extends JpaRepository<VentoModal, Integer>{

}
