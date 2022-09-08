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
@Table(name="radiacao_global")
public class RadiacaoGlobalModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_radiacao")
	private Integer codRadiacao;
	@ManyToOne
    @JoinColumn(name = "cod_wmo", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	
	@Column(name = "radiacao_global")
	private BigDecimalType radiacaoGlobal;
	@Column(name= "datahora_captacao", nullable = false)
	private Timestamp datahoraCaptacao;
	public Integer getCodRadiacao() {
		return codRadiacao;
	}
	public void setCodRadiacao(Integer codRadiacao) {
		this.codRadiacao = codRadiacao;
	}
	public EstacaoModal getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(EstacaoModal codWmo) {
		this.codWmo = codWmo;
	}
	public BigDecimalType getRadiacaoGlobal() {
		return radiacaoGlobal;
	}
	public void setRadiacaoGlobal(BigDecimalType radiacaoGlobal) {
		this.radiacaoGlobal = radiacaoGlobal;
	}
	public Timestamp getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Timestamp datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	@Override
	public String toString() {
		return "RadiacaoGlobalModal [codRadiacao=" + codRadiacao + ", codWmo=" + codWmo + ", radiacaoGlobal="
				+ radiacaoGlobal + ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	

}
