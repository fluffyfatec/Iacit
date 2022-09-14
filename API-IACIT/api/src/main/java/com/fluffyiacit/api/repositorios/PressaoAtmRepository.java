package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.PressaoAtmosfericaModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;

public interface PressaoAtmRepository   extends JpaRepository<ViewPressaoAtmModal, Integer>{
	
	@Query ("SELECT pa FROM view_pressaoatmosferica_dados pa WHERE pa.estacao_estado = :estacao_estado AND pa.estacao_nome = :estacao_nome AND pa.cod_wmo = :cod_wmo AND pa.datahora_captacao = :datahora_captacao")
	public List<ViewPressaoAtmModal> listar(@Param("estacao_estado") String estacao_estado,
										  @Param("estacao_nome") String estacao_nome,
										  @Param("cod_wmo") String cod_wmo,
	  									  @Param("datahora_captacao") Timestamp datahora_captacao);


}
