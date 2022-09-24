package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_pressaoatmosferica_dados")
@Immutable
@Getter	
@Setter
public class ViewPressaoAtmModal {
	
	
	
	@Column(name = "pressaoAtmEstacao")
	private String pressaoAtmEstacao;
	
	@Column(name = "pressaoAtmMax")
	private String pressaoAtmMax;
	
	@Column(name = "pressaoAtmMin")
	private String pressaoAtmMin;
	
    @Id
	@Column(name= "codWmo",length = 4, nullable = false)
	private String codWmo;
	
	@Column(name= "estacaoEstado",length = 2, nullable = false)
	private String estacaoEstado;
	
	@Column(name= "estacaoNome",length = 60, nullable = false, unique = true)
	private String estacaoNome;
	
	@Column(name= "datahoraCaptacao")
	private Timestamp datahoraCaptacao;


}
