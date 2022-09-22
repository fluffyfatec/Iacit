package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;

public interface RadiacaoGlobalRepository  extends JpaRepository<ViewRadiacaoglobalModal, String> {
	@Query ("SELECT rg FROM view_radiacaoglobal_dados rg WHERE rg.estacaoEstado = :estacaoEstado AND rg.estacaoNome = :estacaoNome AND rg.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewRadiacaoglobalModal> listar(@Param("estacaoEstado") String estacaoEstado,
											  @Param("estacaoNome") String estacaoNome,
											  //@Param("cod_wmo") String cod_wmo,
											  @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
}
