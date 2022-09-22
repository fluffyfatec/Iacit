package com.fluffyiacit.api.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "view_filtro_estacao")
@Immutable
@Getter
@Setter
public class ViewFiltroEstacao {
	
	@Id
	@Column(name = "codWmo", length = 4, nullable = false)
	private String codWmo;
	
	@Column(name = "estacaoEstado")
	private String estacaoEstado;

	@Column(name = "estacaoNome")
	private String estacaoNome;
}
