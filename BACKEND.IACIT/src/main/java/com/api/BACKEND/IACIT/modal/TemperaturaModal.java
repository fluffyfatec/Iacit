package com.api.BACKEND.IACIT.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "temperatura")
public class TemperaturaModal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codTemperatura;
	@Column(length = 4, nullable = false)
	private String codWmo;
	private Double temperaturaAr;
	private Double temperaturaMin;
	private Double temperaturaMax;
	private Double temperaturaPontoOrvalho;
	private Double temperaturaOrvalhoMin;
	private Double temperaturaOrvalhoMax;
	@Column(nullable = false)
	private String datahoraCaptacao;
	
	
	public Integer getCodTemperatura() {
		return codTemperatura;
	}
	public void setCodTemperatura(Integer codTemperatura) {
		this.codTemperatura = codTemperatura;
	}
	public String getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(String codWmo) {
		this.codWmo = codWmo;
	}
	public Double getTemperaturaAr() {
		return temperaturaAr;
	}
	public void setTemperaturaAr(Double temperaturaAr) {
		this.temperaturaAr = temperaturaAr;
	}
	public Double getTemperaturaMin() {
		return temperaturaMin;
	}
	public void setTemperaturaMin(Double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}
	public Double getTemperaturaMax() {
		return temperaturaMax;
	}
	public void setTemperaturaMax(Double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	public Double getTemperaturaPontoOrvalho() {
		return temperaturaPontoOrvalho;
	}
	public void setTemperaturaPontoOrvalho(Double temperaturaPontoOrvalho) {
		this.temperaturaPontoOrvalho = temperaturaPontoOrvalho;
	}
	public Double getTemperaturaOrvalhoMin() {
		return temperaturaOrvalhoMin;
	}
	public void setTemperaturaOrvalhoMin(Double temperaturaOrvalhoMin) {
		this.temperaturaOrvalhoMin = temperaturaOrvalhoMin;
	}
	public Double getTemperaturaOrvalhoMax() {
		return temperaturaOrvalhoMax;
	}
	public void setTemperaturaOrvalhoMax(Double temperaturaOrvalhoMax) {
		this.temperaturaOrvalhoMax = temperaturaOrvalhoMax;
	}
	public String getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(String datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	@Override
	public String toString() {
		return "TemperaturaModal [codTemperatura=" + codTemperatura + ", codWmo=" + codWmo + ", temperaturaAr="
				+ temperaturaAr + ", temperaturaMin=" + temperaturaMin + ", temperaturaMax=" + temperaturaMax
				+ ", temperaturaPontoOrvalho=" + temperaturaPontoOrvalho + ", temperaturaOrvalhoMin="
				+ temperaturaOrvalhoMin + ", temperaturaOrvalhoMax=" + temperaturaOrvalhoMax + ", datahoraCaptacao="
				+ datahoraCaptacao + "]";
	} 
}
