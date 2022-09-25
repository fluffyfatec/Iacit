package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;

public interface RadiacaoGlobalRepository  extends JpaRepository<ViewRadiacaoglobalModal, String> {
	@Query ("SELECT rg FROM view_radiacaoglobal_dados rg WHERE rg.estacaoEstado = :estacaoEstado AND rg.estacaoNome = :estacaoNome AND rg.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewRadiacaoglobalModal> listar(@Param("estacaoEstado") String estacaoEstado,
											  @Param("estacaoNome") String estacaoNome,
											  //@Param("cod_wmo") String cod_wmo,
											  @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
	
	@Query(value = "SELECT * FROM view_radiacaoglobal_dados rg WHERE rg.estacao_estado = :estacaoEstado AND rg.estacao_nome = :estacaoNome AND rg.datahora_captacao BETWEEN (CAST(:datahoraCaptacao AS TIMESTAMP) - INTERVAL '7 days') AND CAST(:datahoraCaptacao AS TIMESTAMP)", nativeQuery = true)
    public List<ViewRadiacaoglobalModal> listarGraph (@Param("estacaoEstado") String estacaoEstado, 
    		@Param("estacaoNome") String estacaoNome,
    		@Param("datahoraCaptacao") Timestamp datahoraCaptacao);	
}
