package com.fluffyiacit.api.service;

import java.util.ArrayList;
import java.util.List;

import com.fluffyiacit.api.dto.ListaEstacaoDTO;
import com.fluffyiacit.api.dto.UsuarioRequestDTO;
import com.fluffyiacit.api.modal.EstacaoModal;
import com.fluffyiacit.api.repository.EstacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ListaEstacaoService {
	@Autowired
	EstacaoRepository estacaoRepository;
	
	public ModelAndView execute() {
		ModelAndView modelAndView = new ModelAndView();
		ListaEstacaoDTO estacaoDto = new ListaEstacaoDTO();
		List<EstacaoModal> listaEstacaoModal = estacaoRepository.listarAllEstacoes();
		List<ListaEstacaoDTO> listaEstacaoDto = new ArrayList<>();
		
		for (EstacaoModal estacaoModal : listaEstacaoModal) {
			estacaoDto.setEstacao_nome(estacaoModal.getEstacaoNome());
			estacaoDto.setEstacao_regiao(estacaoModal.getEstacaoRegiao());
			estacaoDto.setEstacao_estado(estacaoModal.getEstacaoEstado());
			estacaoDto.setEstacao_longitude(estacaoModal.getEstacaoLongitude());
			estacaoDto.setEstacao_altitude(estacaoModal.getEstacaoAltitude());
			estacaoDto.setEstacao_latitude(estacaoModal.getEstacaoLatitude());
			estacaoDto.setEstacao_status(estacaoModal.getEstacaoStatus());
			
			listaEstacaoDto.add(estacaoDto);
			
			System.err.println(listaEstacaoDto.toString());
		}

		modelAndView.addObject("escrever algo aqui", estacaoDto);
		
		modelAndView.setViewName("aqui tambem");
		
		return modelAndView;	}
}
