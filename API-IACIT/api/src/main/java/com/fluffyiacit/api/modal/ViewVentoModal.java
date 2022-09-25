package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "view_vento_dados")
@Immutable
@Getter
@Setter
public class ViewVentoModal {
	@Column(name = "ventoVelocidade")
	private String ventoVelocidade;

	@Column(name = "ventoRajadaMax")
	private String ventoRajadaMax;

	@Column(name = "ventoDirecaoHorario")
	private String ventoDirecaoHorario;
	
	@Column(name = "codWmo", length = 4, nullable = false)
	private String codWmo;

	@Column(name = "estacaoEstado", length = 2, nullable = false)
	private String estacaoEstado;

	@Column(name = "estacaoNome", length = 60, nullable = false, unique = true)
	private String estacaoNome;

	@Id
	@Column(name = "datahoraCaptacao")
	private Timestamp datahoraCaptacao;
}
