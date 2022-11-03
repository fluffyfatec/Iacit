package com.fluffyiacit.api.service;

import java.util.Base64.Encoder;

import com.fluffyiacit.api.modal.PermissaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.PermissaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import DTO.UsuarioRequestDTO;

@Service
public class UpdateUsuarioService {

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PermissaoRepository permissaoRepository;
	
	public UsuarioRequestDTO execute(UsuarioRequestDTO data) {
		
		UsuarioModal userAdmin = usuarioRepository.findByUsuarioUsername(data.getUsuario_nome_adm());
		
		System.out.println(userAdmin);
		
		PermissaoModal permissao = permissaoRepository.findByPermissaoNome(data.getNome_permissao());
		
		System.out.println(permissao);
		
		UsuarioModal user = usuarioRepository.findByUsuarioUsername(data.getUsuario_nome());
		
		System.out.println(user);
		
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		String senhaEncriptografada = encode.encode(data.getUsuario_senha());
		
		user.setCodPermissao(permissao);
		user.setUsuarioCadastrante(userAdmin);
		user.setUsuarioNome(data.getUsuario_nome());
		user.setUsuarioSenha(senhaEncriptografada);
		user.setUsuarioUsername(data.getUsuario_username());
		
		usuarioRepository.save(user);
		
		return null;
	}
}
