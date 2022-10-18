package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;



@Entity (name = "view_temperatura_dados")
@Immutable
@Getter	
@Setter

public class ViewTemperaturaModal {
	
	@Column(name = "temperaturaAr")
	private String temperaturaAr;
	
	@Column(name = "temperaturaMin")
	private String temperaturaMin;
	
	@Column(name = "temperaturaMax")
	private String temperaturaMax;
	
	@Column(name = "temperaturaOrvalhoMin")
	private String temperaturaOrvalhoMin;
	
	@Column(name = "temperaturaOrvalhoMax")
	private String temperaturaOrvalhoMax;
	
	@Column(name = "temperaturaPontoOrvalho")
	private String temperaturaPontoOrvalho;
	
	@Column(name= "codWmo",length = 4, nullable = false)
	private String codWmo;
	
	@Column(name= "estacaoEstado",length = 2, nullable = false)
	private String estacaoEstado;
	
	@Column(name= "estacaoNome",length = 60, nullable = false, unique = true)
	private String estacaoNome;
	
	@Id
	@Column(name= "datahoraCaptacao")
	private Timestamp datahoraCaptacao;

}
