package com.api.BACKEND.IACIT.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Vento")
public class VentoModal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codVento;
	
	@Column(length = 4, nullable = false)
	private String codWmoVento;
	private Double ventVelocidade;
	private Double ventRajada;
	private Double VentDireHorario;
	
	@Column(nullable = false)
	private String dtHoraCapitacao;
	
    public Integer getCodVento() {
		return codVento;
	}
	public void setCodVento(Integer codVento) {
		this.codVento = codVento;
	}
	public String getCodWmoVento() {
		return codWmoVento;
	}
	public void setCodWmoVento(String codWmoVento) {
		this.codWmoVento = codWmoVento;
	}
	public Double getVentVelocidade() {
		return ventVelocidade;
	}
	public void setVentVelocidade(Double ventVelocidade) {
		this.ventVelocidade = ventVelocidade;
	}
	public Double getVentRajada() {
		return ventRajada;
	}
	public void setVentRajada(Double ventRajada) {
		this.ventRajada = ventRajada;
	}
	public Double getVentDireHorario() {
		return VentDireHorario;
	}
	public void setVentDireHorario(Double ventDireHorario) {
		VentDireHorario = ventDireHorario;
	}
	public String getDtHoraCapitacao() {
		return dtHoraCapitacao;
	}
	public void setDtHoraCapitacao(String dtHoraCapitacao) {
		this.dtHoraCapitacao = dtHoraCapitacao;
	}
	
	@Override
	public String toString() {
		return "VentoModal [codVento=" + codVento + ", codWmoVento=" + codWmoVento + ", ventVelocidade="
				+ ventVelocidade + ", ventRajada=" + ventRajada + ", VentDireHorario=" + VentDireHorario
				+ ", dtHoraCapitacao=" + dtHoraCapitacao + "]";
	}
}
