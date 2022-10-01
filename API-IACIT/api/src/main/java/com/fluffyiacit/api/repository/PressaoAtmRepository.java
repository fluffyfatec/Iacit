package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;

public interface PressaoAtmRepository   extends JpaRepository<ViewPressaoAtmModal, Integer>{
	
	@Query ("SELECT pa FROM view_pressaoatmosferica_dados pa WHERE pa.estacaoEstado = :estacaoEstado AND pa.estacaoNome = :estacaoNome AND pa.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewPressaoAtmModal> listar(@Param("estacaoEstado") String estacaoEstado,
										  @Param("estacaoNome") String estacaoNome,
										  //@Param("cod_wmo") String cod_wmo,
	  									  @Param("datahoraCaptacao") Timestamp datahoraCaptacao);

	@Query(value = "SELECT * FROM view_pressaoatmosferica_dados pa WHERE pa.estacao_estado = :estacaoEstado AND pa.estacao_nome = :estacaoNome AND pa.datahora_captacao BETWEEN (CAST(:datahoraCaptacao AS TIMESTAMP) - INTERVAL '7 days') AND CAST(:datahoraCaptacao AS TIMESTAMP)", nativeQuery = true)
    public List<ViewPressaoAtmModal> listarGraph (@Param("estacaoEstado") String estacaoEstado, 
    		@Param("estacaoNome") String estacaoNome,
    		@Param("datahoraCaptacao") Timestamp datahoraCaptacao);	

	@Query(value = "SELECT * FROM view_pressaoatmosferica_dados u WHERE u.estacao_estado = :estacaoEstado AND u.estacao_nome = :estacaoNome AND u.datahora_captacao BETWEEN CAST(:dataHoraInicial AS TIMESTAMP) AND CAST(:dataHoraFinal AS TIMESTAMP) ORDER BY u.datahora_captacao ASC", nativeQuery = true)
    public List<ViewPressaoAtmModal> listarGraphPressao (@Param("estacaoEstado") String estacaoEstado, 
    		@Param("estacaoNome") String estacaoNome,
    		@Param("dataHoraInicial") Timestamp dataHoraInicial,
    		@Param("dataHoraFinal") Timestamp dataHoraFinal);	
}
