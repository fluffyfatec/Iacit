package com.fluffyiacit.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewUsuario;
import com.fluffyiacit.api.repository.UsuarioRepository;
import com.fluffyiacit.api.repository.UsuarioTabRepository;
import com.fluffyiacit.api.service.UsuarioService;

import DTO.LoginSessao;
import DTO.UsuarioDTO;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    UsuarioRepository usuariorepository;
    
    @Autowired
    UsuarioTabRepository usuariotabrepository;
    
    
	//CADASTRAR USUARIO
	@RequestMapping(value = { "/cadastro/{usuario_nome}/{usuario_username}/{usuario_senha}/{nome_permissao}/{usuario_adm}/{usuario_alterou}/{sessaoPermissao}" }, method = RequestMethod.GET)
	public ModelAndView cadastrar(@PathVariable("usuario_nome") String usuario_nome,
            					   	@PathVariable("usuario_username") String usuario_username,
            					   	@PathVariable("usuario_senha") String usuario_senha,
            					   	@PathVariable("nome_permissao") String nome_permissao,
            					   	@PathVariable("usuario_adm") String usuario_adm,
            					   	@PathVariable("usuario_alterou") String usuario_alterou,
            					   	@PathVariable("sessaoPermissao") String sessaoPermissao) {
		UsuarioDTO usuario = new UsuarioDTO();
		LoginSessao sessao = new LoginSessao();
		usuario.setUsuario_nome(usuario_nome);
		usuario.setUsuario_username(usuario_username);
		usuario.setUsuario_senha(usuario_senha);
		usuario.setNome_permissao(nome_permissao);
		usuario.setUsuario_adm(usuario_adm);
		usuario.setUsuario_alterou(usuario_alterou);
		
		sessao.setUsuario(usuario_adm);
		sessao.setPermissao(sessaoPermissao);
		return usuarioService.criarUsuario(usuario, sessao);
		 
				
	}
	
	//LISTAR EDITAR
	@RequestMapping(value = { "/editar/{usuarioUsername}" }, method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("usuarioUsername") String usuarioUsername) {
		ViewUsuario usuario = new ViewUsuario();
		usuario.setUsuarioUsername(usuarioUsername);
		return usuarioService.listar(usuario);
	}
	

	//FILTRO AJAX - USUARIO
	@RequestMapping(value = { "/tabela/{id}" }, method = RequestMethod.GET)
	public ModelAndView filtroAjaxUsuario(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		List<ViewUsuario> filtrousuario = usuariotabrepository.listarusuario(id);
		modelAndView.addObject("filtrousuario", filtrousuario);
		modelAndView.setViewName("AjaxTabUsuario");
		return modelAndView;
	}
	
}

