package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.UmidadeModal;
import com.fluffyiacit.api.modal.ViewRadiacaoglobalModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;

public interface UmidadeRepository   extends JpaRepository<ViewUmidadeModal, String> {
	@Query ("SELECT u.umidade_relativa_ar,u.umidade_relativa_max,u.umidade_relativa_min FROM umidade AS u INNER JOIN estacao AS e ON e.cod_wmo = u.cod_wmo WHERE e.estacao_estado = :estacao_estado  AND e.estacao_nome = :estacao_nome AND e.cod_wmo = :cod_wmo AND u.datahora_captacao = :datahora_captacao ")
	public List<ViewUmidadeModal> listar(@Param("estacao_estado") String estacao_estado,
										        @Param("estacao_nome") String estacao_nome,
										        @Param("cod_wmo") String cod_wmo,
	  									        @Param("datahora_captacao") Timestamp datahora_captacao);
}
