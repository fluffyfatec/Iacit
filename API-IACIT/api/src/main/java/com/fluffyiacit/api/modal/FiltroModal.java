package com.fluffyiacit.api.modal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FiltroModal {

	private String estacaoEstado;
	private String estacaoNome;
	private String codWmo;
	private String datahoraCaptacao;
	private String dataHoraInicial;
	private String dataHoraFinal;
	
}