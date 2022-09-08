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
@Table(name = "precipitacao")

public class PrecipitacaoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_preciptacao")
	private Integer codPrecipitacao;
	
	@ManyToOne
    @JoinColumn(name = "cod_wmo", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	
	@Column(name = "precipitacaototal")
	private Double precipitacaototal;
	@Column(name= "datahora_captacao",nullable = false)
	private Date datahoraCaptacao;
	
	public Integer getCodPreciptacao() {
		return codPrecipitacao;
	}
	public void setCodPreciptacao(Integer codPreciptacao) {
		this.codPrecipitacao = codPreciptacao;
	}
	public EstacaoModal getCodWmo() {
		return codWmo;
	}
	public void EstacaoModal (EstacaoModal codWmo) {
		this.codWmo = codWmo;
	}
	public Double getPreciptacaototal() {
		return precipitacaototal;
	}
	public void setPreciptacaototal(Double preciptacaototal) {
		this.precipitacaototal = preciptacaototal;
	}
	public Date getDatahora_captacao() {
		return datahoraCaptacao;
	}
	public void setDatahora_captacao(Date datahora_captacao) {
		this.datahoraCaptacao = datahora_captacao;
	}
	@Override
	public String toString() {
		return "PrecipitacaoModal [codPreciptacao=" + codPrecipitacao + ", codWmo=" + codWmo + ", preciptacaototal="
				+ precipitacaototal + ", datahora_captacao=" + datahoraCaptacao + "]";
	}
	
	
}