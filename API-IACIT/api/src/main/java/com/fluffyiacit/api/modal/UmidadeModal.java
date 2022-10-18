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

@Entity(name="umidade")
@Table(name="umidade")
@Getter
@Setter
@ToString
public class UmidadeModal  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codUmidade")
	private Integer codUmidade;

	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "codWmo")
	private EstacaoModal codWmo;
    
	@Column(name = "umidadeRelativaAr")
	private BigDecimalType umidadeRelativaAr;
   
	@Column(name = "umidadeRelativaMin")
	private BigDecimalType umidadeRelativaMin;
	
	@Column(name = "umidadeRelativaMax")
	private BigDecimalType umidadeRelativaMax;
	
	@Column(name = "datahoraCaptacao" ,nullable = false)
	private Timestamp datahoraCaptacao;
	
	
}
