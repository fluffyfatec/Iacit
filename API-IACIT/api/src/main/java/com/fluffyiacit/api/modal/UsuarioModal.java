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

@Entity(name="usuario")
@Table(name="usuario")
@Getter
@Setter
@ToString
public class UsuarioModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codUsuario")
	private Integer codUsuario;
	
	@Column( name= "usuario_nome",length = 60,nullable = false)
	private String usuarioNome ;
	
	@Column( name= "usuario_username",length = 20,nullable = false)
	private String usuarioUsername;
	
	@Column( name= "usuario_senha",length = 20,nullable = false)
	private String usuarioSenha ;
	
	@Column( name= "usuario_datahora_criacao",nullable = false)
	private Timestamp usuarioDatahoraCriacao;
	
	@ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "codUsuario")
	private UsuarioModal usuarioCadastrante; 
	
	@ManyToOne
    @JoinColumn(name = "permissao", referencedColumnName = "codPermissao")
	private PermissaoModal codPermissao;
}