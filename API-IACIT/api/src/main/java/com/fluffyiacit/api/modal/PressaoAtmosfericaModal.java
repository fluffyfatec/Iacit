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

@Entity(name="pressao_atmosferica")
@Table(name="pressao_atmosferica")
@Getter
@Setter
@ToString
public class PressaoAtmosfericaModal {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codPressaoAtm")
	private Integer codPressaoAtm;
	
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "codWmo")
	private EstacaoModal codWmo;
	
	@Column(name = "pressaoAtmEstacao")
	private BigDecimalType pressaoAtmEstacao;
	
	@Column(name = "pressaoAtmMin")
	private BigDecimalType pressaoAtmMin;
	
	@Column(name = "pressaoAtmMax")
	private BigDecimalType pressaoAtmMax;
	
	@Column(name = "datahoraCaptacao", nullable = false)
	private Timestamp datahoraCaptacao;
	
	
	
	
}
