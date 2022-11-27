package com.fluffyiacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.UsuarioModal;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModal, String> {
	@Query("SELECT v FROM usuario v WHERE v.usuarioNome = :usuarioNome")
	public List<UsuarioModal> listarusuario(@Param("usuarioNome") String usuarioNome);
	

	UsuarioModal findByUsuarioUsername(String usuarioUsername);
}