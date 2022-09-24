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

@Entity(name="radiacao_global")
@Table(name="radiacao_global")
@Getter
@Setter
@ToString
public class RadiacaoGlobalModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codRadiacao")
	private Integer codRadiacao;
	
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "codWmo")
	private EstacaoModal codWmo;
	
	@Column(name = "radiacaoGlobal")
	private BigDecimalType radiacaoGlobal;
	
	@Column(name= "datahoraCaptacao", nullable = false)
	private Timestamp datahoraCaptacao;
	
	

}
