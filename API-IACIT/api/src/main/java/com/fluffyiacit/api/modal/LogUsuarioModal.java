package com.fluffyiacit.api.modal;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="logUsuario")
@Table(name="logUsuario")
@Getter
@Setter
@ToString
public class LogUsuarioModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logUsuarioCod")
	private Integer logUsuarioCod;

	@Column( name= "logUsuarioColunaafetada",length = 60,nullable = false)
	private String logUsuarioColunaafetada; 
	
	@Column( name= "logUsuarioValorantigo",length = 60,nullable = false)
	private String logUsuarioValorantigo;
	
	@Column( name= "logUsuarioDatahora",length = 60,nullable = false)
	private String logUsuarioValornovo;
	
	@Column( name= "logUsuarioDatahora",nullable = false, insertable=false, updatable=false)
	private Timestamp logUsuarioDatahora; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codUsuarioAlterado", referencedColumnName = "codUsuario")
	private UsuarioModal codUsuarioAlterado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codUsuarioAlterou", referencedColumnName = "codUsuario")
	private UsuarioModal codUsuarioAlterou; 
	
	
	
}
