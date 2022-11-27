package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.PermissaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.PermissaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;

import DTO.LoginSessao;
import DTO.UsuarioRequestDTO;

@Service
public class UpdateUsuarioService {

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PermissaoRepository permissaoRepository;
	public ModelAndView execute(UsuarioRequestDTO data, LoginSessao sessao) {
		ModelAndView modelAndView = new ModelAndView();
		UsuarioModal userAdmin = usuarioRepository.findByUsuarioUsername(data.getUsuario_nome_adm());	
		PermissaoModal permissao = permissaoRepository.findByPermissaoNome(data.getNome_permissao());
		UsuarioModal user = usuarioRepository.findByUsuarioUsername(data.getUsuario_username());
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		String senhaEncriptografada = encode.encode(data.getUsuario_senha());

		user.setCodPermissao(permissao);
		user.setUsuarioCadastrante(userAdmin);
		user.setUsuarioNome(data.getUsuario_nome());
		user.setUsuarioSenha(senhaEncriptografada);
		user.setUsuarioUsername(data.getUsuario_username());
		user.setUsuarioAlterou(userAdmin);
		
		usuarioRepository.save(user);
		modelAndView.addObject("sessao", sessao);
		modelAndView.setViewName("HfefCadUsuario");
		return modelAndView;
	}
}
