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
	@Column(name= "codPermissao", nullable = true)
	private Integer codPermissao;
	
	@Column(name= "permissaoNome",length = 50, nullable = true)
	private String permissaoNome;
	
	@Column(name= "permissaoDescricao",length = 200, nullable = true)
	private String permissaoDescricao; 

}
