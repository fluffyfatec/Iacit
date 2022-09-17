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
	@Column(name = "cod_wmo", length = 4, nullable = false)
	private String cod_wmo;
	
	@Column(name = "estacao_estado")
	private String estacao_estado;

	@Column(name = "estacao_nome")
	private String estacao_nome;
}
