package com.fluffyiacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.LogUsuarioModal;

@Repository
public interface LogRepository extends JpaRepository<LogUsuarioModal, String> {
	
	LogUsuarioModal  findByLogCodUsuario(String logCodUsuario);

 }
