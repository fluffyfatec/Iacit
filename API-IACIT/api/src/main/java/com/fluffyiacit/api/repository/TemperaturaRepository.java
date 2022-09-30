package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewTemperaturaModal;

public interface TemperaturaRepository   extends JpaRepository<ViewTemperaturaModal, Integer>{
	
	@Query ("SELECT t FROM view_temperatura_dados t WHERE t.estacaoEstado = :estacaoEstado AND t.estacaoNome = :estacaoNome AND t.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewTemperaturaModal> listar(@Param("estacaoEstado") String estacaoEstado,
										  @Param("estacaoNome") String estacaoNome,
										  //@Param("cod_wmo") String cod_wmo,
	  									  @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
	
	@Query(value = "SELECT * FROM view_temperatura_dados t WHERE t.estacao_estado = :estacaoEstado AND t.estacao_nome = :estacaoNome AND t.datahora_captacao BETWEEN (CAST(:datahoraCaptacao AS TIMESTAMP) - INTERVAL '7 days') AND CAST(:datahoraCaptacao AS TIMESTAMP)", nativeQuery = true)
    public List<ViewTemperaturaModal> listarGraph (@Param("estacaoEstado") String estacaoEstado, 
    		@Param("estacaoNome") String estacaoNome,
    		@Param("datahoraCaptacao") Timestamp datahoraCaptacao);

	@Query(value = "SELECT * FROM view_temperatura_dados u WHERE u.estacao_estado = :estacaoEstado AND u.estacao_nome = :estacaoNome AND u.datahora_captacao BETWEEN CAST(:dataHoraInicial AS TIMESTAMP) AND CAST(:dataHoraFinal AS TIMESTAMP) ORDER BY u.datahora_captacao ASC", nativeQuery = true)
	public List<ViewTemperaturaModal> listarGraphTemperatura (@Param("estacaoEstado") String estacaoEstado,
																@Param("estacaoNome") String estacaoNome,
																@Param("dataHoraInicial") Timestamp dataHoraInicial,
																@Param("dataHoraFinal") Timestamp dataHoraFinal);

}
