package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;

public interface RadiacaoGlobalRepository  extends JpaRepository<ViewRadiacaoglobalModal, String> {
	@Query ("SELECT rg.radiacao_global,rg.cod_wmo FROM radiacao_global AS rg INNER JOIN estacao AS e ON e.cod_wmo = rg.cod_wmo WHERE e.estacao_estado = 'DF' AND e.estacao_nome = :estacao_nome AND e.cod_wmo = :cod_wmo AND rg.datahora_captacao = :datahora_captacao")
	public List<ViewRadiacaoglobalModal> listar(@Param("estacao_estado") String estacao_estado,
										        @Param("estacao_nome") String estacao_nome,
										        @Param("cod_wmo") String cod_wmo,
	  									        @Param("datahora_captacao") Timestamp datahora_captacao);
}
