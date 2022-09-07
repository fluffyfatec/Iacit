package com.api.BACKEND.IACIT.modal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "pressaoAtmosferica")
public class PressaoAtmosfericaModal {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPressaoAtm;
	@Column(length = 4, nullable = false)
	private String codWmo;
	private Double pressaoAtmEstacao;
	private Double pressaoAtmMin;
	private Double pressaoAtmMax;
	@Column(nullable = false)
	private Date datahoraCaptacao;
	
	public Integer getCodPressaoAtm() {
		return codPressaoAtm;
	}
	public void setCodPressaoAtm(Integer codPressaoAtm) {
		this.codPressaoAtm = codPressaoAtm;
	}
	public String getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(String codWmo) {
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
