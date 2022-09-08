package com.api.BACKEND.IACIT.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "temperatura")
public class TemperaturaModal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_temperatura")
	private Integer codTemperatura;
	@ManyToOne
    @JoinColumn(name = "cod_wmo", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	@Column(name = "temperatura_ar")
	private Double temperaturaAr;
	@Column(name = "temperatura_min")
	private Double temperaturaMin;
	@Column(name = "temperatura_max")
	private Double temperaturaMax;
	@Column(name = "temperatura_ponto_orvalho")
	private Double temperaturaPontoOrvalho;
	@Column(name = "temperatura_ponto_min")

	private Double temperaturaOrvalhoMin;
	@Column(name = "temperatura_ponto_max")
	private Double temperaturaOrvalhoMax;
	@Column(name= "datahora_captacao",nullable = false)
	private Date datahoraCaptacao;
	public Integer getCodTemperatura() {
		return codTemperatura;
	}
	public void setCodTemperatura(Integer codTemperatura) {
		this.codTemperatura = codTemperatura;
	}
	public EstacaoModal getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(EstacaoModal codWmo) {
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
	public Date getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Date datahoraCaptacao) {
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
