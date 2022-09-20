package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;


public interface PrecipitacaoRepository extends JpaRepository<ViewPrecipitacaoModal, String> {
	@Query ("SELECT vp FROM view_precipitacao_dados vp WHERE vp.estacao_estado = :estacao_estado AND vp.estacao_nome = :estacao_nome AND vp.datahora_captacao = :datahora_captacao ")
	public List<ViewPrecipitacaoModal> listar(@Param("estacao_estado") String estacao_estado,
										  @Param("estacao_nome") String estacao_nome,
										  //@Param("cod_wmo") String cod_wmo,
	  									  @Param("datahora_captacao") Timestamp datahora_captacao);

										   
}
