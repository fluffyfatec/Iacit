package com.fluffyiacit.api.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vento")
@Getter
@Setter
@ToString

public class VentoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_vento")
	private Integer codVento;
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	@Column(name = "vento_velocidade")

	private BigDecimal ventoVelocidade;
	@Column(name = "vento_rajada_max")
	private BigDecimal ventoRajadaMax;
	@Column(name = "vento_direcao_horario")
	BigDecimal ventoDirecaoHorario;
	
	@Column(name ="datahoraCaptacao",nullable = false)
	private Timestamp datahoraCaptacao;

	

}
