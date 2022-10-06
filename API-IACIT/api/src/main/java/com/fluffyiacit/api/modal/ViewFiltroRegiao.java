package com.fluffyiacit.api.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "view_filtro_regiao")
@Immutable
@Getter
@Setter
public class ViewFiltroRegiao {
	
	
	@Column(name= "estacaoRegiao")
	private String estacaoRegiao;
	
	@Id
	@Column(name= "estacaoEstado")
	private String estacaoEstado;
}
