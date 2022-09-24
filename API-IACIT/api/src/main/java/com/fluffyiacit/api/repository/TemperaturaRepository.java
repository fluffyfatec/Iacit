package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewTemperaturaModal;

public interface TemperaturaRepository   extends JpaRepository<ViewTemperaturaModal, Integer>{
	
	@Query ("SELECT t FROM view_temperatura_dados t WHERE t.estacaoEstado = :estacaoEstado AND t.estacaoNome = :estacaoNome AND t.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewTemperaturaModal> listar(@Param("estacaoEstado") String estacaoEstado,
										  @Param("estacaoNome") String estacaoNome,
										  //@Param("cod_wmo") String cod_wmo,
	  									  @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
	
	
	


}
