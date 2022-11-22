package DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ListaEstacaoDTO {
	private String estacao_nome;
	private String estacao_regiao;
	private String estacao_estado;
	private BigDecimal estacao_latitude;
	private BigDecimal estacao_altitude;
	private BigDecimal estacao_longitude;
	private String estacao_status;
}
