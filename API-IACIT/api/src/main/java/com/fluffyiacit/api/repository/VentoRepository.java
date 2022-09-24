package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewVentoModal;

public interface VentoRepository extends JpaRepository<ViewVentoModal, String> {
	@Query ("SELECT v FROM view_vento_dados v WHERE v.estacaoEstado = :estacaoEstado AND v.estacaoNome = :estacaoNome AND v.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewVentoModal> listar(@Param("estacaoEstado") String estacaoEstado,
										        @Param("estacaoNome") String estacaoNome,
										        //@Param("cod_wmo") String cod_wmo,
	  									        @Param("datahoraCaptacao") Timestamp datahoraCaptacao);
}
