package com.api.BACKEND.IACIT.modal;

import java.sql.Date;

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

	private Double ventoVelocidade;
	@Column(name = "vento_rajada_max")
	private Double ventoRajadaMax;
	@Column(name = "vento_direcao_horario")
	Double ventoDirecaoHorario;
	
	@Column(name ="datahoraCaptacao",nullable = false)
	private Date datahoraCaptacao;

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

	public Double getVentoVelocidade() {
		return ventoVelocidade;
	}

	public void setVentoVelocidade(Double ventoVelocidade) {
		this.ventoVelocidade = ventoVelocidade;
	}

	public Double getVentoRajadaMax() {
		return ventoRajadaMax;
	}

	public void setVentoRajadaMax(Double ventoRajadaMax) {
		this.ventoRajadaMax = ventoRajadaMax;
	}

	public Double getVentoDirecaoHorario() {
		return ventoDirecaoHorario;
	}

	public void setVentoDirecaoHorario(Double ventoDirecaoHorario) {
		this.ventoDirecaoHorario = ventoDirecaoHorario;
	}

	public Date getDatahoraCaptacao() {
		return datahoraCaptacao;
	}

	public void setDatahoraCaptacao(Date datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}

	@Override
	public String toString() {
		return "VentoModal [codVento=" + codVento + ", codWmo=" + codWmo + ", ventoVelocidade=" + ventoVelocidade
				+ ", ventoRajadaMax=" + ventoRajadaMax + ", ventoDirecaoHorario=" + ventoDirecaoHorario
				+ ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	
	
	


}
