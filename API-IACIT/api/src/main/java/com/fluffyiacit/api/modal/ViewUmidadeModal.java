package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "view_umidade_dados")
@Immutable
@Getter
@Setter
public class ViewUmidadeModal {

	@Column(name = "umidade_relativa_ar")
	private String umidade_relativa_ar;

	@Column(name = "umidade_relativa_min")
	private String umidade_relativa_min;

	@Column(name = "umidade_relativa_max")
	private String umidade_relativa_max;

	@Id
	@Column(name = "cod_wmo", length = 4, nullable = false)
	private String cod_wmo;

	@Column(name = "estacao_estado", length = 2, nullable = false)
	private String estacao_estado;

	@Column(name = "estacao_nome", length = 60, nullable = false, unique = true)
	private String estacao_nome;

	@Column(name = "datahora_captacao")
	private Timestamp datahora_captacao;

}
