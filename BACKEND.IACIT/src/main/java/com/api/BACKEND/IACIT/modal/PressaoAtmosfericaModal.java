package com.api.BACKEND.IACIT.modal;

import java.sql.Date;
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
import org.hibernate.type.descriptor.sql.BigDecimalType;

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
	private BigDecimalType pressaoAtmEstacao;
	@Column(name = "pressao_atm_min")
	private BigDecimalType pressaoAtmMin;
	@Column(name = "pressao_atm_max")
	private BigDecimalType pressaoAtmMax;
	@Column(name = "datahora_captacao", nullable = false)
	private Timestamp datahoraCaptacao;
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
	public BigDecimalType getPressaoAtmEstacao() {
		return pressaoAtmEstacao;
	}
	public void setPressaoAtmEstacao(BigDecimalType pressaoAtmEstacao) {
		this.pressaoAtmEstacao = pressaoAtmEstacao;
	}
	public BigDecimalType getPressaoAtmMin() {
		return pressaoAtmMin;
	}
	public void setPressaoAtmMin(BigDecimalType pressaoAtmMin) {
		this.pressaoAtmMin = pressaoAtmMin;
	}
	public BigDecimalType getPressaoAtmMax() {
		return pressaoAtmMax;
	}
	public void setPressaoAtmMax(BigDecimalType pressaoAtmMax) {
		this.pressaoAtmMax = pressaoAtmMax;
	}
	public Timestamp getDatahoraCaptacao() {
		return datahoraCaptacao;
	}
	public void setDatahoraCaptacao(Timestamp datahoraCaptacao) {
		this.datahoraCaptacao = datahoraCaptacao;
	}
	@Override
	public String toString() {
		return "PressaoAtmosfericaModal [codPressaoAtm=" + codPressaoAtm + ", codWmo=" + codWmo + ", pressaoAtmEstacao="
				+ pressaoAtmEstacao + ", pressaoAtmMin=" + pressaoAtmMin + ", pressaoAtmMax=" + pressaoAtmMax
				+ ", datahoraCaptacao=" + datahoraCaptacao + "]";
	}
	
	
}
