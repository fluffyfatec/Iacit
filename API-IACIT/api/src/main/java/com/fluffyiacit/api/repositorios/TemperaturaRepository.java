package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.TemperaturaModal;
import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;

public interface TemperaturaRepository   extends JpaRepository<TemperaturaModal, Integer>{
	
	@Query ("SELECT t.temperatura_ar,t.temperatura_max,t.temperatura_min,t.temperatura_orvalho_max,t.temperatura_orvalho_min,t.temperatura_ponto_orvalho FROM temperatura AS t INNER JOIN estacao AS e ON e.cod_wmo = t.cod_wmo WHERE e.estacao_estado = :estacao_estado AND e.estacao_nome = :estacao_nome AND e.cod_wmo = :cod_wmo AND t.datahora_captacao = :datahora_captacao")
	public List<ViewTemperaturaModal> listar(@Param("estacao_estado") String estacao_estado,
										  @Param("estacao_nome") String estacao_nome,
										  @Param("cod_wmo") String cod_wmo,
	  									  @Param("datahora_captacao") Timestamp datahora_captacao);
	
	
	


}
