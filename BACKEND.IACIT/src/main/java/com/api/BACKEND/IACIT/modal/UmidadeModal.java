package com.api.BACKEND.IACIT.modal;

import java.io.Serializable;
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
	private Double umidadeRelativaAr;
    @Column(name = "umidade_relativa_min")
	private Double umidadeRelativaMin;
	@Column(name = "umidade_relativa_max")
	private Double umidadeRelativaMax;
	@Column(name = "datahora_captacao" ,nullable = false)
	private Date datahoraCaptacao;
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
		return "UmidadeModal [codUmidade=" + codUmidade + ", cod_wmo=" + cod_wmo + ", umidadeRelativaAr="
				+ umidadeRelativaAr + ", umidadeRelativaMin=" + umidadeRelativaMin + ", umidadeRelativaMax="
				+ umidadeRelativaMax + ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	
	
	
}
