package com.api.BACKEND.IACIT.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.BigDecimalType;


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
	private BigDecimalType temperaturaAr;
	@Column(name = "temperatura_min")
	private BigDecimalType temperaturaMin;
	@Column(name = "temperatura_max")
	private BigDecimalType temperaturaMax;
	@Column(name = "temperatura_ponto_orvalho")
	private BigDecimalType temperaturaPontoOrvalho;
	@Column(name = "temperatura_ponto_min")

	private BigDecimalType temperaturaOrvalhoMin;
	@Column(name = "temperatura_ponto_max")
	private BigDecimalType temperaturaOrvalhoMax;
	@Column(name= "datahora_captacao",nullable = false)
	private Timestamp datahoraCaptacao;
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
	public BigDecimalType getTemperaturaAr() {
		return temperaturaAr;
	}
	public void setTemperaturaAr(BigDecimalType temperaturaAr) {
		this.temperaturaAr = temperaturaAr;
	}
	public BigDecimalType getTemperaturaMin() {
		return temperaturaMin;
	}
	public void setTemperaturaMin(BigDecimalType temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}
	public BigDecimalType getTemperaturaMax() {
		return temperaturaMax;
	}
	public void setTemperaturaMax(BigDecimalType temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	public BigDecimalType getTemperaturaPontoOrvalho() {
		return temperaturaPontoOrvalho;
	}
	public void setTemperaturaPontoOrvalho(BigDecimalType temperaturaPontoOrvalho) {
		this.temperaturaPontoOrvalho = temperaturaPontoOrvalho;
	}
	public BigDecimalType getTemperaturaOrvalhoMin() {
		return temperaturaOrvalhoMin;
	}
	public void setTemperaturaOrvalhoMin(BigDecimalType temperaturaOrvalhoMin) {
		this.temperaturaOrvalhoMin = temperaturaOrvalhoMin;
	}
	public BigDecimalType getTemperaturaOrvalhoMax() {
		return temperaturaOrvalhoMax;
	}
	public void setTemperaturaOrvalhoMax(BigDecimalType temperaturaOrvalhoMax) {
		this.temperaturaOrvalhoMax = temperaturaOrvalhoMax;
	}
	public Timestamp getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Timestamp datahoraCaptacao) {
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
