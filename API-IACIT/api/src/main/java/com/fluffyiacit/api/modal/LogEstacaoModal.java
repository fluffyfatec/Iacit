package com.fluffyiacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "logEstacao")
@Table(name = "logEstacao")
@Getter
@Setter
@ToString
public class LogEstacaoModal {

	@Column(name = "logCodWmo", length = 4, nullable = false)
	private String logCodWmo;

	@Column(name = "logEstacaoNome", length = 60, nullable = false, unique = true)
	public String logEstacaoNome;

	@Column(name = "logEstacaoEstado", length = 2, nullable = false)
	public String logEstacaoEstado;

	@Column(name = "logEstacaoRegiao", length = 60, nullable = false)
	private String logEstacaoRegiao;

	@Column(name = "logEstacaoStatus", length = 60, nullable = false)
	private String logEstacaoStatus;

	@Column(name = "logEstacaoAlterou")
	private Integer logEstacaoAlterou;

	@Id
	@Column(name = "logEstacaoDatahoraAlterecao", nullable = false)
	@UpdateTimestamp
	private Timestamp logEstacaoDatahoraAlterecao;
	
	@Column(name = "logEstacaoOperacao", length = 1, nullable = false)
	private String logEstacaoOperacao;
}
