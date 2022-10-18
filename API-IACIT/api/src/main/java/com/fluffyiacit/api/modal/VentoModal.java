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

@Entity(name="vento")
@Table(name="vento")
@Getter
@Setter
@ToString

public class VentoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codVento")
	private Integer codVento;
	
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "codWmo")
	private EstacaoModal codWmo;
	
	@Column(name = "ventoVelocidade")
	private BigDecimal ventoVelocidade;
	
	
	@Column(name = "ventoRajadaMax")
	private BigDecimal ventoRajadaMax;
	
	@Column(name = "ventoDirecaoHorario")
	private BigDecimal ventoDirecaoHorario;
	
	@Column(name ="datahoraCaptacao",nullable = false)
	private Timestamp datahoraCaptacao;

	

}
