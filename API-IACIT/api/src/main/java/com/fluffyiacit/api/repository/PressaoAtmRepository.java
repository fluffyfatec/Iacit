package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewPressaoAtmModal;

public interface PressaoAtmRepository   extends JpaRepository<ViewPressaoAtmModal, Integer>{
	
	@Query ("SELECT pa FROM view_pressaoatmosferica_dados pa WHERE pa.estacaoEstado = :estacaoEstado AND pa.estacaoNome = :estacaoNome AND pa.datahoraCaptacao = :datahoraCaptacao")
	public List<ViewPressaoAtmModal> listar(@Param("estacaoEstado") String estacaoEstado,
										  @Param("estacaoNome") String estacaoNome,
										  //@Param("cod_wmo") String cod_wmo,
	  									  @Param("datahoraCaptacao") Timestamp datahoraCaptacao);


}
