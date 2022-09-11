package com.fluffyiacit.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.EstacaoModal;

@Repository
public interface EstacaoRepository  extends JpaRepository<EstacaoModal, String>{
	
	@Query("SELECT u FROM estacao u WHERE u.cod_wmo = :cod_wmo")
	public List<EstacaoModal> listar(@Param("cod_wmo") String cod_wmo);
	
}
