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
@Table(name="pressao_atmosferica")
@Getter
@Setter
@ToString
public class PressaoAtmosfericaModal {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pressao_atm")
	private Integer codPressaoAtm;
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	@Column(name = "pressao_atm_estacao")
	private BigDecimalType pressaoAtmEstacao;
	@Column(name = "pressao_atm_min")
	private BigDecimalType pressaoAtmMin;
	@Column(name = "pressao_atm_max")
	private BigDecimalType pressaoAtmMax;
	@Column(name = "datahora_captacao", nullable = false)
	private Timestamp datahoraCaptacao;
	
	
	
	
}
