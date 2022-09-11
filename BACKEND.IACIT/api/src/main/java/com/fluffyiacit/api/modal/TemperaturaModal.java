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
@Table (name = "temperatura")
@Getter
@Setter
@ToString
public class TemperaturaModal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_temperatura")
	private Integer codTemperatura;
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	@Column(name = "temperatura_ar")
	private BigDecimalType temperaturaAr;
	@Column(name = "temperatura_min")
	private BigDecimalType temperaturaMin;
	@Column(name = "temperatura_max")
	private BigDecimalType temperaturaMax;
	@Column(name = "temperatura_ponto_orvalho")
	private BigDecimalType temperaturaPontoOrvalho;
	@Column(name = "temperatura_ponto_min")

	private BigDecimalType temperaturaOrvalhoMin;
	@Column(name = "temperatura_ponto_max")
	private BigDecimalType temperaturaOrvalhoMax;
	@Column(name= "datahora_captacao",nullable = false)
	private Timestamp datahoraCaptacao;
	
}
