package DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FiltroDTO {

	private String estacao_estado;
	private String estacao_nome;
	private String cod_wmo;
	private String datahora_captacao;
	
}
