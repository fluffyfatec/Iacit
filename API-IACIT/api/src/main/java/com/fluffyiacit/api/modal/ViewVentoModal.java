package com.fluffyiacit.api.modal;

import java.math.BigDecimal;
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
	@Column(name = "vento_velocidade")
	private String vento_velocidade;

	@Column(name = "vento_rajada_max")
	private String vento_rajada_max;

	@Column(name = "vento_direcao_horario")
	private String vento_direcao_horario;
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
