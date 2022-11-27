package com.fluffyiacit.api.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "view_est_tab")
@Immutable
@Getter
@Setter
public class ViewFiltroEstacaoTab {
	
	@Id
	@Column(name = "codWmo", length = 4, nullable = false)
	private String codWmo;
	
	@Column(name = "estacaoNome", length = 60, nullable = false)
	private String estacaoNome;
	
	@Column(name = "estacaoEstado", length = 2, nullable = false)
	private String estacaoEstado;
	
	@Column(name = "estacaoStatus", length = 1, nullable = false)
	private String estacaoStatus;

	
	
}
