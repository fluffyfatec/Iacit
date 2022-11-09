package com.fluffyiacit.api.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name= "estacao")
@Table(name= "estacao")
@Getter
@Setter
@ToString

public class EstacaoModal {
	
	@Id
	@Column(name= "codWmo",length = 4, nullable = false)
	private String codWmo;
	
	@Column(name= "estacaoNome",length = 60, nullable = false, unique = true)
	private String estacaoNome;
	
	@Column(name= "estacaoRegiao",length = 60, nullable = false)
	private String estacaoRegiao;
	
	@Column(name= "estacaoEstado",length = 2, nullable = false)
	private String estacaoEstado;
	
	@Column( name= "estacaoLongitude",length = 20,nullable = false)
	private BigDecimal estacaoLongitude;
	
	@Column(name ="estacaoLatitude",length = 20,nullable = false)
	private BigDecimal estacaoLatitude;
	
	@Column(name="estacaoAltitude",length = 20, nullable = false)
	private BigDecimal estacaoAltitude;
	
	@Column(name="estacaoDatafundacao", nullable = false)
	private Timestamp estacaoDatafundacao;
	
	@Column(name = "estacaoStatus", length = 1, nullable = false)
	private String estacaoStatus;
	
	
}
