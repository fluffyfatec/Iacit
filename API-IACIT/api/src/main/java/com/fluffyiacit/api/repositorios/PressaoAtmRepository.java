package com.fluffyiacit.api.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.PressaoAtmosfericaModal;
import com.fluffyiacit.api.modal.ViewPressaoAtmModal;

public interface PressaoAtmRepository   extends JpaRepository<PressaoAtmosfericaModal, Integer>{
	
	@Query ("SELECT pa.pressao_atm_estacao,pa.pressao_atm_max,pa.pressao_atm_min,pa.cod_wmo FROM pressao_atmosferica AS pa INNER JOIN estacao AS e ON e.cod_wmo = pa.cod_wmo WHERE e.estacao_estado = :estacao_estado AND e.estacao_nome = :estacao_nome AND e.cod_wmo = :cod_wmo AND pa.datahora_captacao = :datahora_captacao ")
	public List<ViewPressaoAtmModal> listar(@Param("estacao_estado") String estacao_estado,
										  @Param("estacao_nome") String estacao_nome,
										  @Param("cod_wmo") String cod_wmo,
	  									  @Param("datahora_captacao") Timestamp datahora_captacao);


}
