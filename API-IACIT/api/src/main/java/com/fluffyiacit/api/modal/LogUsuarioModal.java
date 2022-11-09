package com.fluffyiacit.api.modal;



import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
	
	@Column(name = "logUsuarioCod")
	private Integer logUsuarioCod;
	
	@Column( name= "logUsuarioNome",length = 60,nullable = false)
	private String logUsuarioNome ;
	
	@Column( name= "logUsuarioUsername",length = 20,nullable = false)
	private String logUsuarioUsername;
	
	@Column( name= "logUsuarioSenha",length = 256,nullable = false)
	private String logUsuarioSenha ;
	
    @Column(name = "logCodPermissao", nullable = false)
	private Integer logCodPermissao;
  
    @Column(name = "logUsuarioAlterou", nullable = false)
	private Integer  logUsuarioAlterou; 
    
    @Id
    @Column( name= "logUsuarioDatahoraAlterecao", nullable = false)
	//@UpdateTimestamp
	private Timestamp logUsuarioDatahoraAlterecao;
    
    @Column(name = "logUsuarioOperacao", nullable = false)
	private String  logUsuarioOperacao; 
    
   
	
}
