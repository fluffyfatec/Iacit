package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.type.BigDecimalType;


@Entity (name = "view_precipitacao_dados")
@Immutable
@Subselect(value = "SELECT * FROM view_precipitacao_dados vp WHERE vp.estacao_estado = estacao_estado AND vp.estacao_nome = estacao_nome AND vp.cod_wmo = cod_wmo")
public class ViewPrecipitacaoModal {
		

		@Column(name = "precipitacaototal")
		private String precipitacaototal;
		
		@Id
		@Column(name= "cod_wmo")
		private String cod_wmo;
		
		@Column(name= "estacao_estado")
		private String estacao_estado;
		
		@Column(name= "estacao_nome")
		private String estacao_nome;
		
		@Column(name= "datahora_captacao")
		private Timestamp datahora_captacao;
	}