package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;
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
	
	@Query(value = "SELECT * FROM view_radiacaoglobal_dados u WHERE u.estacao_estado = :estacaoEstado AND u.estacao_nome = :estacaoNome AND u.datahora_captacao BETWEEN CAST(:dataHoraInicial AS TIMESTAMP) AND CAST(:dataHoraFinal AS TIMESTAMP) ORDER BY u.datahora_captacao ASC", nativeQuery = true)
    public List<ViewRadiacaoglobalModal> listarGraphRadiacao (@Param("estacaoEstado") String estacaoEstado,
    		@Param("estacaoNome") String estacaoNome,
    		@Param("dataHoraInicial") Timestamp dataHoraInicial,
    		@Param("dataHoraFinal") Timestamp dataHoraFinal);

	@Query(value = "SELECT CASE WHEN EXISTS (SELECT datahora_captacao FROM radiacao_global WHERE datahora_captacao= :dataLimite) THEN 'TRUE' ELSE 'FALSE' END", nativeQuery = true)
	public boolean dataLimite (@Param("dataLimite") Timestamp dataLimite);
}
