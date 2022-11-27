package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.service.UpdateUsuarioService;

import DTO.LoginSessao;
import DTO.UsuarioRequestDTO;

@Controller
@RequestMapping(value="/update")
public class UpdateUsuarioController {
	
	@Autowired
	UpdateUsuarioService updateUsuarioService;
	
	@RequestMapping(value = { "/editar/{UsuarioNome}/{UsuarioUsername}/{UsuarioSenha}/{PermissaoNome}/{CodUsuario}/{Cadastrante}/{Alterante}/{SessaoPermissao}" }, method = RequestMethod.GET)
	public ModelAndView editarStatus(@PathVariable("CodUsuario") String CodUsuario,
								   	@PathVariable("UsuarioNome") String UsuarioNome,
								   	@PathVariable("UsuarioUsername") String UsuarioUsername,
								   	@PathVariable("UsuarioSenha") String UsuarioSenha,
								   	@PathVariable("PermissaoNome") String PermissaoNome,
								   	@PathVariable("Cadastrante") String Cadastrante,
								   	@PathVariable("Alterante") String Alterante,
								   	@PathVariable("SessaoPermissao") String SessaoPermissao) {
		UsuarioRequestDTO data = new UsuarioRequestDTO();
		LoginSessao sessao = new LoginSessao();
		data.setCod_usuario(CodUsuario);
		data.setUsuario_nome(UsuarioNome);
		data.setUsuario_username(UsuarioUsername);
		data.setUsuario_senha(UsuarioSenha);
		data.setNome_permissao(PermissaoNome);
		data.setUsuario_cadastrante(Cadastrante);
		data.setUsuario_nome_adm(Alterante);
		
		sessao.setUsuario(Alterante);
		sessao.setPermissao(SessaoPermissao);
		ModelAndView retorno = updateUsuarioService.execute(data, sessao);
		return retorno;
	}
	

}
