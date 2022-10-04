package DTO;

import java.util.List;

import com.fluffyiacit.api.modal.ViewPrecipitacaoModal;

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
	public void addAttribute(String string, List<ViewPrecipitacaoModal> rangePrecipitacao) {
		// TODO Auto-generated method stub
		
	}
	
}
