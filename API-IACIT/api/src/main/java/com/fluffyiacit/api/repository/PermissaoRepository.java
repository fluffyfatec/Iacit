package com.fluffyiacit.api.repository;

import com.fluffyiacit.api.modal.PermissaoModal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoModal, String> {

	PermissaoModal findByCodPermissao(Integer codPermissao);
	
	PermissaoModal findByPermissaoNome(String permissaoNome);

}

