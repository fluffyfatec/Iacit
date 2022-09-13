package com.fluffyiacit.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluffyiacit.api.modal.PrecipitacaoModal;

public interface PrecipitacaoRepository  extends JpaRepository<PrecipitacaoModal, Integer>{

}
