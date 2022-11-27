package com.fluffyiacit.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.UsuarioRepository;
import com.fluffyiacit.api.service.UsuarioService;

import DTO.EstacaoDTO;
import DTO.UsuarioDTO;

@RestController
@RequestMapping(value = "/cadastro")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    UsuarioRepository usuariorepository;
    

    
//	@RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
//	public ModelAndView editarStatus(UsuarioModal usuario) {
//		ModelAndView modelAndView = new ModelAndView();
//		// FILTROS DE DADOS
//		usuario.getUsuarioNome();
//		
//		estacao.getEstacaoNome();
//		estacao.getEstacaoEstado();
//		estacao.getEstacaoStatus();
//		System.out.println(estacao.getEstacaoNome());
//		System.out.println(estacao.getEstacaoEstado());
//		System.out.println(estacao.getEstacaoStatus());
//		
//		return adm.update(estacao);
//	}

	//LISTAR EDITAR
	@RequestMapping(value = { "/editar/{usuarioUsername}" }, method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("usuarioUsername") String usuarioUsername) {
		UsuarioModal usuario = new UsuarioModal();
		usuario.setUsuarioUsername(usuarioUsername);
		return usuarioService.listar(usuario);
	}
	
	
	//CADASTRAR
	@RequestMapping(value = { "/cad/{usuario_nome}/{usuario_username}/{usuario_senha}/{nome_permissao}/{usuario_adm}/{usuario_alterou}" }, method = RequestMethod.GET)
	public ModelAndView filtroAjax1(@PathVariable("usuario_nome") String usuario_nome,
            					   	@PathVariable("usuario_username") String usuario_username,
            					   	@PathVariable("usuario_senha") String usuario_senha,
            					   	@PathVariable("nome_permissao") String nome_permissao,
            					   	@PathVariable("usuario_adm") String usuario_adm,
            					   	@PathVariable("usuario_alterou") String usuario_alterou) {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setUsuario_nome(usuario_nome);
		usuario.setUsuario_username(usuario_username);
		usuario.setUsuario_senha(usuario_senha);
		usuario.setNome_permissao(nome_permissao);
		usuario.setUsuario_adm(usuario_adm);
		usuario.setUsuario_alterou(usuario_alterou);
		return usuarioService.criarUsuario(usuario);
	}
	

	//FILTRO AJAX - USUARIO
	@RequestMapping(value = { "/usu/{id}" }, method = RequestMethod.GET)
	public ModelAndView filtroAjaxUsuario(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();

		List<UsuarioModal> filtrousuario = usuariorepository.listarusuario(id);
		modelAndView.addObject("filtrousuario", filtrousuario);
		
		modelAndView.setViewName("AjaxTabUsuario");
		return modelAndView;
	}
	
}

