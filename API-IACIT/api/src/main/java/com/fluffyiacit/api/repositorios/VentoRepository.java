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
	@Query ("SELECT v.vento_direcao_horario,v.vento_rajada_max,v.vento_velocidade,v.datahora_captacao,v.cod_wmo FROM vento AS v INNER JOIN estacao AS e ON e.cod_wmo = v.cod_wmo WHERE e.estacao_estado = :estacao_estado AND e.estacao_nome = :estacao_nome AND e.cod_wmo = :cod_wmo AND v.datahora_captacao = :datahora_captacao ")
	public List<ViewVentoModal> listar(@Param("estacao_estado") String estacao_estado,
										        @Param("estacao_nome") String estacao_nome,
										        @Param("cod_wmo") String cod_wmo,
	  									        @Param("datahora_captacao") Timestamp datahora_captacao);
}
