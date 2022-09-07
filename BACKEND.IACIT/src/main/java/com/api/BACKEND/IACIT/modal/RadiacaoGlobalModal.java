package com.api.BACKEND.IACIT.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "radiacaoGlobal")
public class RadiacaoGlobalModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codRadiacao;
	@Column(length = 4, nullable = false)
	private String codWmo;
	private Double radiacaoGlobal;
	@Column(nullable = false)
	private Date datahoraCaptacao;
	
	public Integer getCodRadiacao() {
		return codRadiacao;
	}
	public void setCodRadiacao(Integer codRadiacao) {
		this.codRadiacao = codRadiacao;
	}
	public String getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(String codWmo) {
		this.codWmo = codWmo;
	}
	public Double getRadiacaoGlobal() {
		return radiacaoGlobal;
	}
	public void setRadiacaoGlobal(Double radiacaoGlobal) {
		this.radiacaoGlobal = radiacaoGlobal;
	}
	public Date getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Date datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	
	@Override
	public String toString() {
		return "RadiacaoGlobalModal [codRadiacao=" + codRadiacao + ", codWmo=" + codWmo + ", radiacaoGlobal="
				+ radiacaoGlobal + ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}

}
