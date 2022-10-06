package com.fluffyiacit.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewFiltroRegiao;

public interface FiltroRegiaoRepository extends JpaRepository<ViewFiltroRegiao, String> {
	@Query("SELECT v FROM view_filtro_regiao v WHERE v.estacaoRegiao = :estacaoRegiao")
	public List<ViewFiltroRegiao> listar(@Param("estacaoRegiao") String estacaoRegiao);

}
