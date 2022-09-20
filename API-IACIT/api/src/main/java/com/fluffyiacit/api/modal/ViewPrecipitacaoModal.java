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
    	@Column(name= "cod_wmo",length = 4, nullable = true)
		private String cod_wmo;
		
    	@Column(name= "estacao_estado",length = 2, nullable = true)
		private String estacao_estado;
		
    	@Column(name= "estacao_nome",length = 60, nullable = true, unique = true)
		private String estacao_nome;
		
		@Column(name= "datahora_captacao")
		private Timestamp datahora_captacao;
		
		
	}