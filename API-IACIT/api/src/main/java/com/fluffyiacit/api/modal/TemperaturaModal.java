package com.fluffyiacit.api.modal;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.BigDecimalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "temperatura")
@Table(name = "temperatura")
@Getter
@Setter
@ToString
public class TemperaturaModal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codTemperatura")
	private Integer codTemperatura;
	
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "codWmo")
	private EstacaoModal codWmo;
	
	@Column(name = "temperaturaAr")
	private BigDecimalType temperaturaAr;
	
	@Column(name = "temperaturaMin")
	private BigDecimalType temperaturaMin;
	
	@Column(name = "temperaturaMax")
	private BigDecimalType temperaturaMax;
	
	@Column(name = "temperaturaPontoOrvalho")
	private BigDecimalType temperaturaPontoOrvalho;
	
	@Column(name = "temperaturaPontoMin")
	private BigDecimalType temperaturaPontoMin;
	
	@Column(name = "temperaturaPontoMax")
	private BigDecimalType temperaturaPontoMax;
	
	@Column(name= "datahoraCaptacao",nullable = false)
	private Timestamp datahoraCaptacao;
	
}
