package com.api.BACKEND.IACIT.modal;

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

@Entity
@Table(name="vento")

public class VentoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_vento")
	private Integer codVento;
	@ManyToOne
    @JoinColumn(name = "cod_wmo", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	@Column(name = "vento_velocidade")

	private BigDecimal ventoVelocidade;
	@Column(name = "vento_rajada_max")
	private BigDecimal ventoRajadaMax;
	@Column(name = "vento_direcao_horario")
	BigDecimal ventoDirecaoHorario;
	
	@Column(name ="datahoraCaptacao",nullable = false)
	private Timestamp datahoraCaptacao;

	public Integer getCodVento() {
		return codVento;
	}

	public void setCodVento(Integer codVento) {
		this.codVento = codVento;
	}

	public EstacaoModal getCodWmo() {
		return codWmo;
	}

	public void setCodWmo(EstacaoModal codWmo) {
		this.codWmo = codWmo;
	}

	public BigDecimal getVentoVelocidade() {
		return ventoVelocidade;
	}

	public void setVentoVelocidade(BigDecimal ventoVelocidade) {
		this.ventoVelocidade = ventoVelocidade;
	}

	public BigDecimal getVentoRajadaMax() {
		return ventoRajadaMax;
	}

	public void setVentoRajadaMax(BigDecimal ventoRajadaMax) {
		this.ventoRajadaMax = ventoRajadaMax;
	}

	public BigDecimal getVentoDirecaoHorario() {
		return ventoDirecaoHorario;
	}

	public void setVentoDirecaoHorario(BigDecimal ventoDirecaoHorario) {
		this.ventoDirecaoHorario = ventoDirecaoHorario;
	}

	public Timestamp getDatahoraCaptacao() {
		return datahoraCaptacao;
	}

	public void setDatahoraCaptacao(Timestamp datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}

	@Override
	public String toString() {
		return "VentoModal [codVento=" + codVento + ", codWmo=" + codWmo + ", ventoVelocidade=" + ventoVelocidade
				+ ", ventoRajadaMax=" + ventoRajadaMax + ", ventoDirecaoHorario=" + ventoDirecaoHorario
				+ ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	
	
	


}
