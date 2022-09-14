package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.type.BigDecimalType;

import lombok.Getter;
import lombok.Setter;



@Entity (name = "view_temperatura_dados")
@Immutable
@Getter	
@Setter

public class ViewTemperaturaModal {
	
	@Column(name = "temperatura_ar")
	private String temperatura_ar;
	
	@Column(name = "temperatura_min")
	private String temperatura_min;
	
	@Column(name = "temperatura_max")
	private String temperatura_max;
	
	@Column(name = "temperatura_orvalho_min")
	private String temperatura_orvalho_min;
	
	@Column(name = "temperatura_orvalho_max")
	private String temperatura_orvalho_max;
	
	@Column(name = "temperatura_ponto_orvalho")
	private String temperatura_ponto_orvalho;
	
    @Id
	@Column(name= "cod_wmo",length = 4, nullable = false)
	private String cod_wmo;
	
	@Column(name= "estacao_estado",length = 2, nullable = false)
	private String estacao_estado;
	
	@Column(name= "estacao_nome",length = 60, nullable = false, unique = true)
	private String estacao_nome;
	
	@Column(name= "datahora_captacao")
	private Timestamp datahora_captacao;

}
