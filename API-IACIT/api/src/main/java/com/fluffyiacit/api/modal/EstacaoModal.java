package com.fluffyiacit.api.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name= "estacao")
@Table(name= "estacao")
@Getter
@Setter
@ToString

public class EstacaoModal {
	
	@Id
	@Column(name= "cod_wmo",length = 4, nullable = false)
	private String cod_wmo;
	@Column(name= "estacao_nome",length = 60, nullable = false, unique = true)
	private String estacao_nome;
	@Column(name= "estacao_regiao",length = 60, nullable = false)
	private String estacao_regiao;
	@Column(name= "estacao_estado",length = 2, nullable = false)
	private String estacao_estado;
	@Column( name= "estacao_longitude",length = 20,nullable = false)
	private BigDecimal estacao_longitude;
	@Column(name ="estacao_latitude",length = 20,nullable = false)
	private BigDecimal estacao_latitude;
	@Column(name="estacao_altitude",length = 20, nullable = false)
	private BigDecimal estacao_altitude;
	@ColumnDefault(value = "A")
	@Column(name="estacao_datafundacao", nullable = false)
	private Timestamp estacao_datafundacao;
	@Column(name = "estacao_status", length = 1, nullable = false)
	private String estacao_status;
	
	
}
