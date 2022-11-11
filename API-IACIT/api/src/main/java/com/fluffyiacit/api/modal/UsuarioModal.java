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

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;



@Entity(name="usuario")
@Table(name="usuario")
@Getter
@Setter
public class UsuarioModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codUsuario")
	private Integer codUsuario;
	
	@Column( name= "usuarioNome",length = 60,nullable = false)
	private String usuarioNome ;
	
	@Column( name= "usuarioUsername",length = 20,nullable = false)
	private String usuarioUsername;
	
	@Column( name= "usuarioSenha",length = 256,nullable = false)
	private String usuarioSenha ;
	
	@UpdateTimestamp
	@Column( name= "usuarioDatahoraCriacao",nullable = false)
	private Timestamp usuarioDatahoraCriacao;
	
	@ManyToOne
    @JoinColumn(name = "usuarioCadastrante", referencedColumnName = "codUsuario")
	private UsuarioModal usuarioCadastrante; 
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuarioAlterou", referencedColumnName = "codUsuario")
	private UsuarioModal usuarioAlterou; 
	
	@ManyToOne
    @JoinColumn(name = "cod_permissao", referencedColumnName = "codPermissao")
	private PermissaoModal codPermissao;

}
