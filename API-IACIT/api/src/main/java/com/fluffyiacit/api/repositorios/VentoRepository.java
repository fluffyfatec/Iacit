package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.VentoModal;
import com.fluffyiacit.api.modal.ViewUmidadeModal;
import com.fluffyiacit.api.modal.ViewVentoModal;

public interface VentoRepository extends JpaRepository<ViewVentoModal, String> {
	@Query ("SELECT v FROM view_vento_dados v WHERE v.estacao_estado = :estacao_estado AND v.estacao_nome = :estacao_nome AND v.cod_wmo = :cod_wmo AND v.datahora_captacao = :datahora_captacao")
	public List<ViewVentoModal> listar(@Param("estacao_estado") String estacao_estado,
										        @Param("estacao_nome") String estacao_nome,
										        @Param("cod_wmo") String cod_wmo,
	  									        @Param("datahora_captacao") Timestamp datahora_captacao);
}
