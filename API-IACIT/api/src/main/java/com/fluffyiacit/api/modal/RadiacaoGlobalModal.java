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
	@Column(name = "cod_radiacao")
	private Integer cod_radiacao;
	
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "cod_wmo")
	private EstacaoModal codWmo;
	
	@Column(name = "radiacao_global")
	private BigDecimalType radiacao_global;
	
	@Column(name= "datahora_captacao", nullable = false)
	private Timestamp datahora_captacao;
	
	

}
