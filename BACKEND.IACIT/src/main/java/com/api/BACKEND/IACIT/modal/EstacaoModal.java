package com.api.BACKEND.IACIT.modal;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name= "estacao")


public class EstacaoModal {
	
	@Id
	@Column(name= "cod_wmo",length = 4, nullable = false)
	private String codWmo;
	@Column(name= "estacao_nome",length = 60, nullable = false, unique = true)
	private String estacaoNome;
	@Column(name= "estacao_regiao",length = 60, nullable = false)
	private String estacaoRegiao;
	@Column(name= "estacao_estado",length = 2, nullable = false)
	private String estacaoEstado;
	@Column( name= "estacaoLogintude",nullable = false)
	private String estacaoLogintude;
	@Column(name ="estacao_latitude",nullable = false)
	private String estacaoLatitude;
	@Column(name="estacao_altidude", nullable = false)
	private String estacaoAltidude;
	@ColumnDefault(value = "A")
	//@Column(name="estacao_datafundacao", nullable = false)
	private Date estacaoDatafundacao;
	@Column(name = "estacao_status", length = 1, nullable = false)
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
	public String getEstacaoLogintude() {
		return estacaoLogintude;
	}
	public void setEstacaoLogintude(String estacaoLogintude) {
		this.estacaoLogintude = estacaoLogintude;
	}
	public String getEstacaoLatitude() {
		return estacaoLatitude;
	}
	public void setEstacaoLatitude(String estacaoLatitude) {
		this.estacaoLatitude = estacaoLatitude;
	}
	public String getEstacaoAltidude() {
		return estacaoAltidude;
	}
	public void setEstacaoAltidude(String estacaoAltidude) {
		this.estacaoAltidude = estacaoAltidude;
	}
	public Date getEstacaoDatafundacao() {
		return estacaoDatafundacao;
	}
	public void setEstacaoDatafundacao(Date estacaoDatafundacao) {
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
				+ ", estacaoEstado=" + estacaoEstado + ", estacaoLogintude=" + estacaoLogintude + ", estacaoLatitude="
				+ estacaoLatitude + ", estacaoAltidude=" + estacaoAltidude + ", estacaoDatafundacao="
				+ estacaoDatafundacao + ", estacaoStatus=" + estacaoStatus + "]";
	}
	
}
