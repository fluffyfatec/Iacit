package com.fluffyiacit.api.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "codWmo",length = 4, nullable = false)
	private String codWmo;
	
	@Column(name= "estacaoNome",length = 60, nullable = false, unique = true)
	public String estacaoNome;
	
	@Column(name= "estacaoRegiao",length = 60, nullable = false)
	private String estacaoRegiao;
	
	@Column(name= "estacaoEstado",length = 2, nullable = false)
	public String estacaoEstado;
	
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
	
	@ManyToOne
    @JoinColumn(name = "usuarioAlterou", referencedColumnName = "codUsuario")
	private UsuarioModal usuarioAlterou; 
	
	
	
}
