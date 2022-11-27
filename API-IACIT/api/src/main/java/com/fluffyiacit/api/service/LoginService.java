package com.fluffyiacit.api.service;

import com.fluffyiacit.api.modal.PermissaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.PermissaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import DTO.LoginDTO;
import DTO.LoginResponseDTO;

@Service
public class LoginService {

	@Autowired(required = true)
	UsuarioRepository usuarioRepository;
	
	@Autowired(required = true)
	PermissaoRepository permissaoRepository;

	public ModelAndView login(LoginDTO login) {
		
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		ModelAndView modelAndView = new ModelAndView();
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		
		UsuarioModal usuario = usuarioRepository.findByUsuarioUsername(login.getUsuario());
		PermissaoModal permissao = permissaoRepository.findByCodPermissao(usuario.getCodUsuario());

//		System.out.println(usuario.getUsuarioNome());
//		System.out.println(usuario.getUsuarioUsername());
//		System.out.println(usuario.getUsuarioSenha());
//		System.out.println(usuario.getCodPermissao());
//		System.out.println(permissao.getPermissaoNome());
//		System.out.println(login.getSenha());
		
		
		if (encode.matches(login.getSenha(), usuario.getUsuarioSenha()) && permissao.getPermissaoNome().equals("Administrator")) {
			System.out.println("oi passou");
			loginResponseDTO.setAdm("true");
			loginResponseDTO.setPasswordMatch("true");
			modelAndView.addObject("permissao", loginResponseDTO);
			modelAndView.setViewName("validalogin");
		}else if(encode.matches(login.getSenha(), usuario.getUsuarioSenha()) && permissao.getPermissaoNome().equals("Usuario")){
			loginResponseDTO.setAdm("false");
			loginResponseDTO.setPasswordMatch("true");
			modelAndView.addObject(loginResponseDTO);
			modelAndView.setViewName("validalogin");
		}else{
			loginResponseDTO.setAdm("false");
			loginResponseDTO.setPasswordMatch("false");
			modelAndView.addObject(loginResponseDTO);
			modelAndView.setViewName("validalogin");
		}

		return modelAndView;
	}

}
