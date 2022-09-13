package com.fluffyiacit.api.modal;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity (name = "view_precipitacao_dados")
@Table(name = "view_precipitacao_dados")
@Immutable
@Getter
@Setter
@ToString
public class ViewPrecipitacaoModal implements Serializable{
		
	private static final long serialVersionUID = 1L;

		@Column(name = "precipitacaototal")
		private String precipitacaototal;
		
		@Id
		@Column(name= "cod_wmo",length = 4, nullable = false)
		private Integer cod_wmo;
		
		@Column(name= "estacao_estado",length = 2, nullable = false)
		private String estacao_estado;
		
		@Column(name= "estacao_nome",length = 60, nullable = false, unique = true)
		private String estacao_nome;
		
		@Column(name= "datahora_captacao",nullable = false)
		private Timestamp datahora_captacao;
	}