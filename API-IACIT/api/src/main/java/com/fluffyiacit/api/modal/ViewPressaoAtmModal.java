package com.fluffyiacit.api.modal;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.type.BigDecimalType;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_pressaoatmosferica_dados")
@Immutable
@Getter	
@Setter
public class ViewPressaoAtmModal {
	
	
	
	@Column(name = "pressao_atm_estacao")
	private String pressao_atm_estacao;
	
	@Column(name = "pressao_atm_max")
	private String pressao_atm_max;
	
	@Column(name = "pressao_atm_min")
	private String pressao_atm_min;
	
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
