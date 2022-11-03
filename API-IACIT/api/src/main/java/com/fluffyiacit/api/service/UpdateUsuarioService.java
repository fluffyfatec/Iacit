package com.fluffyiacit.api.service;

import com.fluffyiacit.api.modal.PermissaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.PermissaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import DTO.UsuarioRequestDTO;

@Service
public class UpdateUsuarioService {

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PermissaoRepository permissaoRepository;
	
	public ModelAndView execute(UsuarioRequestDTO data) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		UsuarioModal userAdmin = usuarioRepository.findByUsuarioUsername(data.getUsuario_nome_adm());
		
		PermissaoModal permissao = permissaoRepository.findByPermissaoNome(data.getNome_permissao());
		
		UsuarioModal user = usuarioRepository.findByUsuarioUsername(data.getUsuario_nome());
		
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		String senhaEncriptografada = encode.encode(data.getUsuario_senha());
		
		user.setCodPermissao(permissao);
		user.setUsuarioCadastrante(userAdmin);
		user.setUsuarioNome(data.getUsuario_nome());
		user.setUsuarioSenha(senhaEncriptografada);
		user.setUsuarioUsername(data.getUsuario_username());
		
		usuarioRepository.save(user);
		
		modelAndView.addObject("colocar o nome do retorno", user);
		
		modelAndView.setViewName("trocar o nome do html aqui");
		
		return modelAndView;
	}
}
