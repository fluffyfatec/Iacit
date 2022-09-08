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
@Table(name="pressao_atmosferica")
public class PressaoAtmosfericaModal {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pressao_atm")
	private Integer codPressaoAtm;
	@ManyToOne
    @JoinColumn(name = "cod_wmo", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	@Column(name = "pressao_atm_estacao")
	private Double pressaoAtmEstacao;
	@Column(name = "pressao_atm_min")
	private Double pressaoAtmMin;
	@Column(name = "pressao_atm_max")
	private Double pressaoAtmMax;
	@Column(name = "datahora_captacao", nullable = false)
	private Date datahoraCaptacao;
	public Integer getCodPressaoAtm() {
		return codPressaoAtm;
	}
	public void setCodPressaoAtm(Integer codPressaoAtm) {
		this.codPressaoAtm = codPressaoAtm;
	}
	public EstacaoModal getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(EstacaoModal codWmo) {
		this.codWmo = codWmo;
	}
	public Double getPressaoAtmEstacao() {
		return pressaoAtmEstacao;
	}
	public void setPressaoAtmEstacao(Double pressaoAtmEstacao) {
		this.pressaoAtmEstacao = pressaoAtmEstacao;
	}
	public Double getPressaoAtmMin() {
		return pressaoAtmMin;
	}
	public void setPressaoAtmMin(Double pressaoAtmMin) {
		this.pressaoAtmMin = pressaoAtmMin;
	}
	public Double getPressaoAtmMax() {
		return pressaoAtmMax;
	}
	public void setPressaoAtmMax(Double pressaoAtmMax) {
		this.pressaoAtmMax = pressaoAtmMax;
	}
	public Date getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Date datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	@Override
	public String toString() {
		return "PressaoAtmosfericaModal [codPressaoAtm=" + codPressaoAtm + ", codWmo=" + codWmo + ", pressaoAtmEstacao="
				+ pressaoAtmEstacao + ", pressaoAtmMin=" + pressaoAtmMin + ", pressaoAtmMax=" + pressaoAtmMax
				+ ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	
	
}
