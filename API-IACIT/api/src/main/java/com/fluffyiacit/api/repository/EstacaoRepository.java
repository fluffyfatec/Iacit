package com.fluffyiacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.EstacaoModal;

@Repository
public interface EstacaoRepository extends JpaRepository<EstacaoModal, String> {

	@Query("SELECT u FROM estacao u WHERE u.codWmo = :codWmo")
	public List<EstacaoModal> listar(@Param("codWmo") String codWmo);
	
	@Query(value = "SELECT * FROM estacao", nativeQuery = true)
	List<EstacaoModal> listarAllEstacoes();
}
