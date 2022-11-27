package com.fluffyiacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.ViewUsuario;
import com.fluffyiacit.api.service.UpdateUsuarioService;

import DTO.UsuarioRequestDTO;

@Controller
@RequestMapping(value="/update")
public class UpdateUsuarioController {
	
	@Autowired
	UpdateUsuarioService updateUsuarioService;
	
	@PostMapping
	public ModelAndView handle(@RequestBody UsuarioRequestDTO data) {
		ModelAndView retorno = updateUsuarioService.execute(data);
		return retorno;
	}
	
	@RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
	public ModelAndView editarStatus(ViewUsuario usuario) {
		UsuarioRequestDTO data = new UsuarioRequestDTO();
		 
		data.setCod_usuario(usuario.getCodUsuario());
		data.setUsuario_nome(usuario.getUsuarioNome());
		data.setUsuario_username(usuario.getUsuarioUsername());
		data.setUsuario_senha(usuario.getUsuarioSenha());
		data.setNome_permissao(usuario.getPermissaoNome());
		data.setUsuario_cadastrante(usuario.getCadastrante());
		data.setUsuario_nome_adm(usuario.getAlterante());
		ModelAndView retorno = updateUsuarioService.execute(data);
		return retorno;
	}
	

}
