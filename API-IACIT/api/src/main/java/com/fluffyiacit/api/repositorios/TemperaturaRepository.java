package com.fluffyiacit.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluffyiacit.api.modal.TemperaturaModal;

public interface TemperaturaRepository   extends JpaRepository<TemperaturaModal, Integer>{

}
