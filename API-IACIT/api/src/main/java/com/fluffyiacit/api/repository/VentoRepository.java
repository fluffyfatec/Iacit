package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewVentoModal;

public interface VentoRepository extends JpaRepository<ViewVentoModal, String> {
	@Query ("SELECT v FROM view_vento_dados v WHERE v.estacaoEstado = :estacaoEstado AND v.estacaoNome = :estacaoNome AND v.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewVentoModal> listar(@Param("estacaoEstado") String estacaoEstado,
										        @Param("estacaoNome") String estacaoNome,
										        //@Param("cod_wmo") String cod_wmo,
	  									        @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
	@Query(value = "SELECT * FROM view_vento_dados v WHERE v.estacao_estado = :estacaoEstado AND v.estacao_nome = :estacaoNome AND v.datahora_captacao BETWEEN (CAST(:datahoraCaptacao AS TIMESTAMP) - INTERVAL '7 days') AND CAST(:datahoraCaptacao AS TIMESTAMP)", nativeQuery = true)
    public List<ViewVentoModal> listarGraph (@Param("estacaoEstado") String estacaoEstado, 
    		@Param("estacaoNome") String estacaoNome,
    		@Param("datahoraCaptacao") Timestamp datahoraCaptacao);	
	
	@Query(value = "SELECT * FROM view_vento_dados u WHERE u.estacao_estado = :estacaoEstado AND u.estacao_nome = :estacaoNome AND u.datahora_captacao BETWEEN CAST(:dataHoraInicial AS TIMESTAMP) AND CAST(:dataHoraFinal AS TIMESTAMP) ORDER BY u.datahora_captacao ASC", nativeQuery = true)
    public List<ViewVentoModal> listarGraphVento (@Param("estacaoEstado") String estacaoEstado, 
    		@Param("estacaoNome") String estacaoNome,
    		@Param("dataHoraInicial") Timestamp dataHoraInicial,
    		@Param("dataHoraFinal") Timestamp dataHoraFinal);
}
