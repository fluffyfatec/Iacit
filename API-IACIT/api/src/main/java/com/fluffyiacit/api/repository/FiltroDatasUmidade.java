package com.fluffyiacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluffyiacit.api.modal.ViewUmidadeModal;

import DTO.FiltroDatasDTO;

public interface FiltroDatasUmidade extends JpaRepository<FiltroDatasDTO, String> {
	@Query(value = "SELECT * FROM view_umidade_dados u WHERE u.estacao_estado = :estacaoEstado AND u.estacao_nome = :estacaoNome AND u.datahora_captacao BETWEEN CAST(:dataHoraInicial AS TIMESTAMP) AND CAST(:dataHoraFinal AS TIMESTAMP)", nativeQuery = true)
    public List<FiltroDatasDTO> listarGraph (@Param("estacaoEstado") String estacaoEstado, 
    		
    		@Param("estacaoNome") String estacaoNome,
    		@Param("dataHoraInicial") Timestamp dataHoraInicial,
    		@Param("dataHoraFinal") Timestamp dataHoraFinal
    		);	
}



