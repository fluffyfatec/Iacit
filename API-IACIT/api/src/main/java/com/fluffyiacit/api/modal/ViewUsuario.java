package com.fluffyiacit.api.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "view_usuario")
@Immutable
@Getter
@Setter
public class ViewUsuario {
	
	@Id
	@Column(name = "codUsuario", length = 4, nullable = false)
	private String codUsuario;
	
	@Column(name = "usuarioNome", length = 60, nullable = false)
	private String usuarioNome;

	@Column(name = "usuarioUsername", length = 60, nullable = false)
	private String usuarioUsername;
	
	@Column(name = "usuarioSenha", length = 256, nullable = false)
	private String usuarioSenha;
	
	@Column(name = "permissaoNome", length = 50, nullable = false)
	private String permissaoNome;
	
	@Column(name = "cadastrante", length = 20, nullable = false)
	private String cadastrante;
	
	@Column(name = "alterante", length = 20, nullable = false)
	private String alterante;
	

}
