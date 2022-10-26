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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="logUsuarioestacao")
@Table(name="logUsuarioestacao")
@Getter
@Setter
@ToString
public class LogUsuarioEstacaoModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logUsuarioestacaoCod")
	private Integer logUsuarioestacaoCod;
	
	@Column( name= "logUsuarioestacaoColunaafetada",length = 60,nullable = false)
	private String logUsuarioestacaoColunaafetada;
	
	@Column( name= "logUsuarioestacaoValorantigo",length = 60,nullable = false)
	private String logUsuarioestacaoValorantigo;
	
	@Column( name= "logUsuarioestacaoValornovo",length = 60,nullable = false)
	private String logUsuarioestacaoValornovo;

	@Column( name= "logUsuarioestacaoDatahora",nullable = false)
	private Timestamp logUsuarioestacaoDatahora;
	
	@ManyToOne
    @JoinColumn(name = "codWmo", referencedColumnName = "codWmo")
	private EstacaoModal codWmo;

	@ManyToOne
    @JoinColumn(name = "codUsuarioAlterou", referencedColumnName = "codUsuario")
	private UsuarioModal codUsuarioAlterou;
}
