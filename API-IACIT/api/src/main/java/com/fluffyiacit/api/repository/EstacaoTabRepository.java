package com.fluffyiacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.ViewFiltroEstacaoTab;

@Repository
public interface EstacaoTabRepository extends JpaRepository<ViewFiltroEstacaoTab, String> {
	@Query("SELECT v FROM view_est_tab v WHERE v.estacaoNome = :estacaoNome")
	public List<ViewFiltroEstacaoTab> listar(@Param("estacaoNome") String estacaoNome);

//	public List<ViewFiltroEstacaoTab> listarAllEstacoes();
//	ViewFiltroEstacaoTab findByEstacaoNome(String estacaoNome); 
 }
