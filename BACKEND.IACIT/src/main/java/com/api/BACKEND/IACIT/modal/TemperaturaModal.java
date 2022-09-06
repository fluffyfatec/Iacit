package com.api.BACKEND.IACIT.modal;

import java.util.Date;

import javax.persistence.Entity;

//@Entity
public class TemperaturaModal {

	private Integer codTemperatura;
	private String codWmo;
	private Double temperaturaAr;
	private Double temperaturaMin;
	private Double temperaturaMax;
	private Double temperaturaPontoOrvalho;
	private Double temperaturaOrvalhoMin;
	private Double temperaturaOrvalhoMax;
	private String datahoraCaptacao; 
}
