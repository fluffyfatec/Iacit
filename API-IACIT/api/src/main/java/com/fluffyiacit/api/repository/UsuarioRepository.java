package com.fluffyiacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.UsuarioModal;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModal, String> {
	
	UsuarioModal findByUsuarioUsername(String usuarioUsername);

}
