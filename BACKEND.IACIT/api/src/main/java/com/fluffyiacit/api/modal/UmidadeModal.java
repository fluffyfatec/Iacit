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

@Entity
@Table(name="umidade")
@Getter
@Setter
@ToString
public class UmidadeModal  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_umidade")
	private Integer codUmidade;

	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "cod_wmo")
	private EstacaoModal cod_wmo;
    @Column(name = "umidade_relativa_ar")
	private BigDecimalType umidadeRelativaAr;
    @Column(name = "umidade_relativa_min")
	private BigDecimalType umidadeRelativaMin;
	@Column(name = "umidade_relativa_max")
	private BigDecimalType umidadeRelativaMax;
	@Column(name = "datahora_captacao" ,nullable = false)
	private Timestamp datahoraCaptacao;
	
	
}
