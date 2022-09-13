package com.fluffyiacit.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;


import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;


public interface PrecipitacaoRepository extends JpaRepository<ViewPrecipitacaoModal, Integer> {
	@Query("SELECT vp FROM view_precipitacao_dados vp WHERE vp.estacao_estado = :estacao_estado AND vp.estacao_nome = :estacao_nome AND vp.cod_wmo = :cod_wmo AND vp.datahora_captacao = :datahora_captacao")
	public List<ViewPrecipitacaoModal> listar(@Param("estacao_estado") String estacao_estado,
										  @Param("estacao_nome") String estacao_nome,
										  @Param("cod_wmo") String cod_wmo,
										  @Param("datahora_captacao") String datahora_captacao);
										   
	
	

}
