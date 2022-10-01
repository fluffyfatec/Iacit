package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;


public interface PrecipitacaoRepository extends JpaRepository<ViewPrecipitacaoModal, String> {
	
	//LISTA 1 DIA
	@Query ("SELECT vp FROM view_precipitacao_dados vp WHERE vp.estacaoEstado = :estacaoEstado AND vp.estacaoNome = :estacaoNome AND vp.datahoraCaptacao = :datahoraCaptacao ")
	public List<ViewPrecipitacaoModal> listUnica(@Param("estacaoEstado") String estacaoEstado,
												 @Param("estacaoNome") String estacaoNome,
			  									 @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
	
	//LISTA RANGE
	@Query(value = "SELECT * FROM view_precipitacao_dados u WHERE u.estacao_estado = :estacaoEstado AND u.estacao_nome = :estacaoNome AND u.datahora_captacao BETWEEN CAST(:dataHoraInicial AS TIMESTAMP) AND CAST(:dataHoraFinal AS TIMESTAMP) ORDER BY u.datahora_captacao ASC", nativeQuery = true)
    public List<ViewPrecipitacaoModal> listRange (@Param("estacaoEstado") String estacaoEstado, 
										    	  @Param("estacaoNome") String estacaoNome,
										    	  @Param("dataHoraInicial") Timestamp dataHoraInicial,
										    	  @Param("dataHoraFinal") Timestamp dataHoraFinal);
	
	//LISTA DATA MENOS 7 DIAS
//	@Query(value = "SELECT * FROM view_precipitacao_dados vp WHERE vp.estacao_estado = :estacaoEstado AND vp.estacao_nome = :estacaoNome AND vp.datahora_captacao BETWEEN (CAST(:datahoraCaptacao AS TIMESTAMP) - INTERVAL '7 days') AND CAST(:datahoraCaptacao AS TIMESTAMP)", nativeQuery = true)
//  public List<ViewPrecipitacaoModal> listDays (@Param("estacaoEstado") String estacaoEstado, 
//									    		 @Param("estacaoNome") String estacaoNome,
//									    		 @Param("datahoraCaptacao") Timestamp datahoraCaptacao);	
	
//	@Query(value = "SELECT CASE WHEN EXISTS (SELECT datahora_captacao FROM precipitacao WHERE datahora_captacao= :dataLimite) THEN 'TRUE' ELSE 'FALSE' END", nativeQuery = true)
//	public boolean dataLimite (@Param("dataLimite") Timestamp dataLimite);
}
