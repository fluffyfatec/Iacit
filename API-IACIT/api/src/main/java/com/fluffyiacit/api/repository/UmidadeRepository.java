package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewUmidadeModal;

public interface UmidadeRepository   extends JpaRepository<ViewUmidadeModal, String> {
	@Query ("SELECT u FROM view_umidade_dados u WHERE u.estacao_estado = :estacao_estado AND u.estacao_nome = :estacao_nome AND u.datahora_captacao = :datahora_captacao")
	public List<ViewUmidadeModal> listar(@Param("estacao_estado") String estacao_estado,
										        @Param("estacao_nome") String estacao_nome,
										        //@Param("cod_wmo") String cod_wmo,
	  									        @Param("datahora_captacao") Timestamp datahora_captacao);
}
