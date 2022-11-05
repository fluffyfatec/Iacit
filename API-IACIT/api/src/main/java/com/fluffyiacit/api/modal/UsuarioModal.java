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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

@Entity(name="usuario")
@Table(name="usuario")
@Getter
@Setter
public class UsuarioModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codUsuario")
	private Integer codUsuario;
	
	@Column( name= "usuarioNome",length = 60,nullable = false)
	private String usuarioNome ;
	
	@Column( name= "usuarioUsername",length = 20,nullable = false)
	private String usuarioUsername;
	
	@Column( name= "usuarioSenha",length = 256,nullable = false)
	private String usuarioSenha ;
	
	@Column( name= "usuarioDatahoraCriacao",nullable = false)
	//@UpdateTimestamp
	private Timestamp usuarioDatahoraCriacao;
	
	@ManyToOne
    @JoinColumn(name = "usuarioCadastrante", referencedColumnName = "codUsuario")
	private UsuarioModal usuarioCadastrante; 
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuarioAlterou", referencedColumnName = "codUsuario")
	private UsuarioModal usuarioAlterou; 
	
	@ManyToOne
    @JoinColumn(name = "permissao", referencedColumnName = "codPermissao")
	private PermissaoModal codPermissao;

}
