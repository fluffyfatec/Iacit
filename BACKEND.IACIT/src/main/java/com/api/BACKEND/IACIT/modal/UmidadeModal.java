package com.api.BACKEND.IACIT.modal;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.BigDecimalType;
import org.hibernate.type.descriptor.sql.BigDecimalType;

@Entity
@Table(name="umidade")
public class UmidadeModal  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_umidade")
	private Integer codUmidade;

	@ManyToOne
    @JoinColumn(name = "cod_wmo", referencedColumnName = "cod_wmo")
	private EstacaoModal cod_wmo;
    @Column(name = "umidade_relativa_ar")
	private BigDecimalType umidadeRelativaAr;
    @Column(name = "umidade_relativa_min")
	private BigDecimalType umidadeRelativaMin;
	@Column(name = "umidade_relativa_max")
	private BigDecimalType umidadeRelativaMax;
	@Column(name = "datahora_captacao" ,nullable = false)
	private Timestamp datahoraCaptacao;
	public Integer getCodUmidade() {
		return codUmidade;
	}
	public void setCodUmidade(Integer codUmidade) {
		this.codUmidade = codUmidade;
	}
	public EstacaoModal getCod_wmo() {
		return cod_wmo;
	}
	public void setCod_wmo(EstacaoModal cod_wmo) {
		this.cod_wmo = cod_wmo;
	}
	public BigDecimalType getUmidadeRelativaAr() {
		return umidadeRelativaAr;
	}
	public void setUmidadeRelativaAr(BigDecimalType umidadeRelativaAr) {
		this.umidadeRelativaAr = umidadeRelativaAr;
	}
	public BigDecimalType getUmidadeRelativaMin() {
		return umidadeRelativaMin;
	}
	public void setUmidadeRelativaMin(BigDecimalType umidadeRelativaMin) {
		this.umidadeRelativaMin = umidadeRelativaMin;
	}
	public BigDecimalType getUmidadeRelativaMax() {
		return umidadeRelativaMax;
	}
	public void setUmidadeRelativaMax(BigDecimalType umidadeRelativaMax) {
		this.umidadeRelativaMax = umidadeRelativaMax;
	}
	public Timestamp getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Timestamp datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	@Override
	public String toString() {
		return "UmidadeModal [codUmidade=" + codUmidade + ", cod_wmo=" + cod_wmo + ", umidadeRelativaAr="
				+ umidadeRelativaAr + ", umidadeRelativaMin=" + umidadeRelativaMin + ", umidadeRelativaMax="
				+ umidadeRelativaMax + ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	
	
	
}
