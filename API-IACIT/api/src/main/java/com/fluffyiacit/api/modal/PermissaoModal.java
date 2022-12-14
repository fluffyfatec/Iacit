package com.fluffyiacit.api.modal;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name= "permissao")
@Table(name= "permissao")
@Getter
@Setter
@ToString


public class PermissaoModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "codPermissao", nullable = false, updatable = false)
	private Integer codPermissao;
	
	@Column(name= "permissao_nome",length = 50, nullable = false)
	private String permissaoNome;
	
	@Column(name= "permissao_descricao",length = 200, nullable = false)
	private String permissaoDescricao; 

}

