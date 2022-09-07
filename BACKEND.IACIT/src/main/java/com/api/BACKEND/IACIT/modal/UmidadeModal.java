package com.api.BACKEND.IACIT.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "umidade")
public class UmidadeModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codUmidade;
	@Column(length = 4, nullable = false)
	private String codWmo;
	private Double umidadeRelativaAr;
	private Double umidadeRelativaMin;
	private Double umidadeRelativaMax;
	@Column(nullable = false)
	private Date datahoraCaptacao;
	
	public Integer getCodUmidade() {
		return codUmidade;
	}
	public void setCodUmidade(Integer codUmidade) {
		this.codUmidade = codUmidade;
	}
	public String getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(String codWmo) {
		this.codWmo = codWmo;
	}
	public Double getUmidadeRelativaAr() {
		return umidadeRelativaAr;
	}
	public void setUmidadeRelativaAr(Double umidadeRelativaAr) {
		this.umidadeRelativaAr = umidadeRelativaAr;
	}
	public Double getUmidadeRelativaMin() {
		return umidadeRelativaMin;
	}
	public void setUmidadeRelativaMin(Double umidadeRelativaMin) {
		this.umidadeRelativaMin = umidadeRelativaMin;
	}
	public Double getUmidadeRelativaMax() {
		return umidadeRelativaMax;
	}
	public void setUmidadeRelativaMax(Double umidadeRelativaMax) {
		this.umidadeRelativaMax = umidadeRelativaMax;
	}
	public Date getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Date datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	
	@Override
	public String toString() {
		return "UmidadeModal [codUmidade=" + codUmidade + ", codWmo=" + codWmo + ", umidadeRelativaAr="
				+ umidadeRelativaAr + ", umidadeRelativaMin=" + umidadeRelativaMin + ", umidadeRelativaMax="
				+ umidadeRelativaMax + ", datahoraCaptacao=" + datahoraCaptacao + "]";
	} 
	
}
