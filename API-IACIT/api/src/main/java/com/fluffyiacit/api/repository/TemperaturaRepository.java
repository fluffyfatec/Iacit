package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewTemperaturaModal;

public interface TemperaturaRepository   extends JpaRepository<ViewTemperaturaModal, Integer>{
	
	@Query ("SELECT t FROM view_temperatura_dados t WHERE t.estacao_estado = :estacao_estado AND t.estacao_nome = :estacao_nome AND t.datahora_captacao = :datahora_captacao")
	public List<ViewTemperaturaModal> listar(@Param("estacao_estado") String estacao_estado,
										  @Param("estacao_nome") String estacao_nome,
										  //@Param("cod_wmo") String cod_wmo,
	  									  @Param("datahora_captacao") Timestamp datahora_captacao);
	
	
	


}
