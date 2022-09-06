package com.api.BACKEND.IACIT.modal;

import java.sql.String;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Preciptacao")

public class PrecipitacaoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPreciptacao;
	
	@Column(length = 4, nullable = false)
	private String codWmo;
	private Double preciptacaototal;
	@Column(nullable = false)
	private String datahora_captacao;
	
	public Integer getCodPreciptacao() {
		return codPreciptacao;
	}
	public void setCodPreciptacao(Integer codPreciptacao) {
		this.codPreciptacao = codPreciptacao;
	}
	public String getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(String codWmo) {
		this.codWmo = codWmo;
	}
	public Double getPreciptacaototal() {
		return preciptacaototal;
	}
	public void setPreciptacaototal(Double preciptacaototal) {
		this.preciptacaototal = preciptacaototal;
	}
	public String getDatahora_captacao() {
		return datahora_captacao;
	}
	public void setDatahora_captacao(String datahora_captacao) {
		this.datahora_captacao = datahora_captacao;
	}
	@Override
	public String toString() {
		return "PrecipitacaoModal [codPreciptacao=" + codPreciptacao + ", codWmo=" + codWmo + ", preciptacaototal="
				+ preciptacaototal + ", datahora_captacao=" + datahora_captacao + "]";
	}
	
	
}