package com.fluffyiacit.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluffyiacit.api.modal.RadiacaoGlobalModal;

public interface RadiacaoGlobalRepository  extends JpaRepository<RadiacaoGlobalModal, Integer> {

}
