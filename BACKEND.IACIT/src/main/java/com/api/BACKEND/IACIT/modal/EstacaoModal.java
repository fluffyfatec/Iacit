package com.api.BACKEND.IACIT.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.type.descriptor.sql.BigDecimal;

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
	@Column( name= "estacaoLongitude",length = 20,nullable = false)
	private BigDecimal estacaoLongitude;
	@Column(name ="estacao_latitude",length = 20,nullable = false)
	private BigDecimal estacaoLatitude;
	@Column(name="estacao_altitude",length = 20, nullable = false)
	private BigDecimal estacaoAltitude;
	@ColumnDefault(value = "A")
	//@Column(name="estacao_datafundacao", nullable = false)
	private Timestamp estacaoDatafundacao;
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
	public BigDecimal getestacaoLongitude() {
		return estacaoLongitude;
	}
	public void setestacaoLongitude(BigDecimal estacaoLongitude) {
		this.estacaoLongitude = estacaoLongitude;
	}
	public BigDecimal getEstacaoLatitude() {
		return estacaoLatitude;
	}
	public void setEstacaoLatitude(BigDecimal estacaoLatitude) {
		this.estacaoLatitude = estacaoLatitude;
	}
	public BigDecimal getestacaoAltitude() {
		return estacaoAltitude;
	}
	public void setestacaoAltitude(BigDecimal estacaoAltitude) {
		this.estacaoAltitude = estacaoAltitude;
	}
	public Timestamp getEstacaoDatafundacao() {
		return estacaoDatafundacao;
	}
	public void setEstacaoDatafundacao(Timestamp estacaoDatafundacao) {
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
				+ ", estacaoEstado=" + estacaoEstado + ", estacaoLongitude=" + estacaoLongitude + ", estacaoLatitude="
				+ estacaoLatitude + ", estacaoAltitude=" + estacaoAltitude + ", estacaoDatafundacao="
				+ estacaoDatafundacao + ", estacaoStatus=" + estacaoStatus + "]";
	}
	
}
