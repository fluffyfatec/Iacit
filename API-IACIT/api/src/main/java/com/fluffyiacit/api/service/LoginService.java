package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.dto.LoginDTO;
import com.fluffyiacit.api.dto.LoginResponseDTO;
import com.fluffyiacit.api.modal.PermissaoModal;
import com.fluffyiacit.api.modal.ViewUsuario;
import com.fluffyiacit.api.repository.PermissaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;
import com.fluffyiacit.api.repository.UsuarioTabRepository;

@Service
public class LoginService {

	@Autowired(required = true)
	UsuarioRepository usuarioRepository;
	
	@Autowired(required = true)
	PermissaoRepository permissaoRepository;
	
	@Autowired(required = true)
	UsuarioTabRepository usuariotabrepository;

	public ModelAndView login(LoginDTO login) {
		ModelAndView modelAndView = new ModelAndView();
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
	    LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

		ViewUsuario usuario = usuariotabrepository.findByUsuarioUsername(login.getUsuario());
        System.err.println(usuario.getPermissaoNome());
        System.err.println(usuario.getUsuarioSenha());
        
        if (encode.matches(login.getSenha(), usuario.getUsuarioSenha()) && usuario.getPermissaoNome().equals("Administrator")) {
            loginResponseDTO.setPermissao("1");
            loginResponseDTO.setPasswordMatch("senha ok");
            modelAndView.addObject("loginResponseDTO", loginResponseDTO);
            modelAndView.addObject("usuario", usuario);
            modelAndView.setViewName("validalogin");
        }else if(encode.matches(login.getSenha(), usuario.getUsuarioSenha()) && usuario.getPermissaoNome().equals("Usuario")){
            loginResponseDTO.setPermissao("2");
            loginResponseDTO.setPasswordMatch("senha ok");
            modelAndView.addObject("loginResponseDTO", loginResponseDTO);
            modelAndView.addObject("usuario", usuario);
            modelAndView.setViewName("validalogin");
        }else{
            loginResponseDTO.setPermissao("0");
            loginResponseDTO.setPasswordMatch("senha errada");
            modelAndView.addObject("loginResponseDTO", loginResponseDTO);
            modelAndView.addObject("usuario", usuario);
            modelAndView.setViewName("validalogin");
        }
        return modelAndView;
    }

}
