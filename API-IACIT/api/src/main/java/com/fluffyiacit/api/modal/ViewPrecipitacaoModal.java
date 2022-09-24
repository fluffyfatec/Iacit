package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;


@Entity (name = "view_precipitacao_dados")
@Immutable
@Getter
@Setter

public class ViewPrecipitacaoModal {
		
        
		@Column(name = "precipitacaototal")
		private String precipitacaototal;
		
        @Id
    	@Column(name= "codWmo",length = 4, nullable = true)
		private String codWmo;
		
    	@Column(name= "estacaoEstado",length = 2, nullable = true)
		private String estacaoEstado;
		
    	@Column(name= "estacaoNome",length = 60, nullable = true, unique = true)
		private String estacaoNome;
		
		@Column(name= "datahoraCaptacao")
		private Timestamp datahoraCaptacao;
		
	}