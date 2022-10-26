package com.fluffyiacit.api.modal;


import java.security.Timestamp;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codUsuario")
	private Integer codUsuario;
	
	@Column( name= "usuarioNome",length = 60,nullable = true)
	private String usuarioNome ;
	
	@Column( name= "usuarioUsername",length = 20,nullable = true)
	private String usuarioUsername;
	
	@Column( name= "usuarioSenha",length = 20,nullable = true)
	private String usuarioSenha ;
	
	@Column( name= "usuarioDatahoraCriacao",nullable = true)
	private Timestamp usuarioDatahoraCriacao;
	
	@Column( name= "usuarioCadastrante",nullable = true)
	private Integer usuarioCadastrante; 
	
	@ManyToOne
    @JoinColumn(name = "permissao", referencedColumnName = "codPermissao")
	private PermissaoModal codPermissao;
	


	


}
