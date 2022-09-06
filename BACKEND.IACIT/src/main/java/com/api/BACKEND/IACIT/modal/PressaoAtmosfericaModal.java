package com.api.BACKEND.IACIT.modal;

import javax.persistence.Entity;

//@Entity
public class PressaoAtmosfericaModal {
 
	private Integer codPressaoAtm;
	private String codWmo;
	private Double pressaoAtmEstacao;
	private Double pressaoAtmMin;
	private Double pressaoAtmMax;
	private String datahoraCaptacao;
}
