package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;

public interface RadiacaoGlobalRepository  extends JpaRepository<ViewRadiacaoglobalModal, String> {
	@Query ("SELECT rg FROM view_radiacaoglobal_dados rg WHERE rg.estacao_estado = :estacao_estado AND rg.estacao_nome = :estacao_nome AND rg.cod_wmo = :cod_wmo AND rg.datahora_captacao = :datahora_captacao")
	public List<ViewRadiacaoglobalModal> listar(@Param("estacao_estado") String estacao_estado,
										        @Param("estacao_nome") String estacao_nome,
										        @Param("cod_wmo") String cod_wmo,
	  									        @Param("datahora_captacao") Timestamp datahora_captacao);
}
