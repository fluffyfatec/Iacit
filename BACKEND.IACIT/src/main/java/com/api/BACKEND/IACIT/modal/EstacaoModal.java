package com.api.BACKEND.IACIT.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "estacao")
public class EstacaoModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 4, nullable = false)
	private String codWmo;
	@Column(length = 60, nullable = false)
	private String estacaoNome;
	@Column(length = 60, nullable = false)
	private String estacaoRegiao;
	@Column(length = 2, nullable = false)
	private String estacaoEstado;
	@Column( nullable = false)
	private Double estacaoLogintude;
	@Column( nullable = false)
	private Double estacaoLatidude;
	@Column( nullable = false)
	private Double estacaoAltidude;
	private String estacaoDatafundacao;
	@Column(length = 1, nullable = false)
	private String estacaoStatus;
	public String getCodWmo() {
		return codWmo;
	}
	public void setCodWmo(String codWmo) {
		this.codWmo = codWmo;
	}
	public String getEstacaoNome() {
		return estacaoNome;
	}
	public void setEstacaoNome(String estacaoNome) {
		this.estacaoNome = estacaoNome;
	}
	public String getEstacaoRegiao() {
		return estacaoRegiao;
	}
	public void setEstacaoRegiao(String estacaoRegiao) {
		this.estacaoRegiao = estacaoRegiao;
	}
	public String getEstacaoEstado() {
		return estacaoEstado;
	}
	public void setEstacaoEstado(String estacaoEstado) {
		this.estacaoEstado = estacaoEstado;
	}
	public Double getEstacaoLogintude() {
		return estacaoLogintude;
	}
	public void setEstacaoLogintude(Double estacaoLogintude) {
		this.estacaoLogintude = estacaoLogintude;
	}
	public Double getEstacaoLatidude() {
		return estacaoLatidude;
	}
	public void setEstacaoLatidude(Double estacaoLatidude) {
		this.estacaoLatidude = estacaoLatidude;
	}
	public Double getEstacaoAltidude() {
		return estacaoAltidude;
	}
	public void setEstacaoAltidude(Double estacaoAltidude) {
		this.estacaoAltidude = estacaoAltidude;
	}
	public String getEstacaoDatafundacao() {
		return estacaoDatafundacao;
	}
	public void setEstacaoDatafundacao(String estacaoDatafundacao) {
		this.estacaoDatafundacao = estacaoDatafundacao;
	}
	public String getEstacaoStatus() {
		return estacaoStatus;
	}
	public void setEstacaoStatus(String estacaoStatus) {
		this.estacaoStatus = estacaoStatus;
	}
	@Override
	public String toString() {
		return "EstacaoModal [codWmo=" + codWmo + ", estacaoNome=" + estacaoNome + ", estacaoRegiao=" + estacaoRegiao
				+ ", estacaoEstado=" + estacaoEstado + ", estacaoLogintude=" + estacaoLogintude + ", estacaoLatidude="
				+ estacaoLatidude + ", estacaoAltidude=" + estacaoAltidude + ", estacaoDatafundacao="
				+ estacaoDatafundacao + ", estacaoStatus=" + estacaoStatus + "]";
	}
}
