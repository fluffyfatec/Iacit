package com.fluffyiacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.ViewUsuario;

@Repository
public interface UsuarioTabRepository extends JpaRepository<ViewUsuario, String> {
	@Query("SELECT v FROM view_usuario v WHERE v.usuarioNome = :usuarioNome")
	public List<ViewUsuario> listarusuario(@Param("usuarioNome") String usuarioNome);
	ViewUsuario findByUsuarioUsername(String usuarioUsername);
}