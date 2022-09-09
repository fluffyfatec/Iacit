package com.api.BACKEND.IACIT.modal;

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

@Entity
@Table(name= "estacao")
@Getter
@Setter
@ToString

public class EstacaoModal {
	
	@Id
	@Column(name= "cod_wmo",length = 4, nullable = false)
	private String codWmo;
	@Column(name= "estacao_nome",length = 60, nullable = false, unique = true)
	private String estacaoNome;
	@Column(name= "estacao_regiao",length = 60, nullable = false)
	private String estacaoRegiao;
	@Column(name= "estacao_estado",length = 2, nullable = false)
	private String estacaoEstado;
	@Column( name= "estacaoLongitude",length = 20,nullable = false)
	private BigDecimal estacaoLongitude;
	@Column(name ="estacao_latitude",length = 20,nullable = false)
	private BigDecimal estacaoLatitude;
	@Column(name="estacao_altitude",length = 20, nullable = false)
	private BigDecimal estacaoAltitude;
	@ColumnDefault(value = "A")
	//@Column(name="estacao_datafundacao", nullable = false)
	private Timestamp estacaoDatafundacao;
	@Column(name = "estacao_status", length = 1, nullable = false)
	private String estacaoStatus;
	
	
}
