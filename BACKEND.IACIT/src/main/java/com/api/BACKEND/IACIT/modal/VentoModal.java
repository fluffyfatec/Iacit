package com.api.BACKEND.IACIT.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Vento")
public class VentoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codVento;
	
	@Column(length = 4, nullable = false)
	private String codWmo;
	private Double ventoVelocidade;
	private Double ventoRajadaMax;
	private Double ventoDirecaoHorario;
	
	@Column(nullable = false)
	private String datahoraCaptacao;
	
    public Integer getCodVento() {
		return codVento;
	}
	public void setCodVento(Integer codVento) {
		this.codVento = codVento;
	}
	public String getcodWmo() {
		return codWmo;
	}
	public void setcodWmo(String codWmo) {
		this.codWmo = codWmo;
	}
	public Double getventoVelocidade() {
		return ventoVelocidade;
	}
	public void setventoVelocidade(Double ventoVelocidade) {
		this.ventoVelocidade = ventoVelocidade;
	}
	public Double getventoRajadaMax() {
		return ventoRajadaMax;
	}
	public void setventoRajadaMax(Double ventoRajadaMax) {
		this.ventoRajadaMax = ventoRajadaMax;
	}
	public Double getventoDirecaoHorario() {
		return ventoDirecaoHorario;
	}
	public void setventoDirecaoHorario(Double ventoDirecaoHorario) {
		ventoDirecaoHorario = ventoDirecaoHorario;
	}
	public String getdatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setdatahoraCaptacao(String datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	
	@Override
	public String toString() {
		return "VentoModal [codVento=" + codVento + ", codWmo=" + codWmo + ", ventoVelocidade="
				+ ventoVelocidade + ", ventoRajadaMax=" + ventoRajadaMax + ", ventoDirecaoHorario=" + ventoDirecaoHorario
				+ ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
}
