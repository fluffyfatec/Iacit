package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewUmidadeModal;

public interface UmidadeRepository   extends JpaRepository<ViewUmidadeModal, String> {
	@Query ("SELECT u FROM view_umidade_dados u WHERE u.estacaoEstado = :estacaoEstado AND u.estacaoNome = :estacaoNome AND u.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewUmidadeModal> listar(@Param("estacaoEstado") String estacaoEstado,
										        @Param("estacaoNome") String estacaoNome,
										        //@Param("cod_wmo") String cod_wmo,
	  									        @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
}
