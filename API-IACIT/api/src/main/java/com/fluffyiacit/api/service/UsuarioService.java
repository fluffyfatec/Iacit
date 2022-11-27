package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.PermissaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.PermissaoRepository;
import com.fluffyiacit.api.repository.UsuarioRepository;

import DTO.UsuarioDTO;

@Service
public class UsuarioService {
	
	 @Autowired
	 private UsuarioRepository repository;
	 
	 @Autowired
	 private PermissaoRepository permrepository;
	 
	 public ModelAndView criarUsuario(UsuarioDTO usuario) {
	     
	 UsuarioModal usuariomodal = new UsuarioModal();
	 
	 UsuarioModal usuarioadm = repository.findByUsuarioUsername(usuario.getUsuario_adm());
	 
	 UsuarioModal usuarioAlterou = repository.findByUsuarioUsername(usuario.getUsuario_alterou());
	 	 	 
	 PermissaoModal permissao =  permrepository.findByPermissaoNome(usuario.getNome_permissao());
	 
	 BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
	 String senhaEncriptada = encode.encode(usuario.getUsuario_senha());
	 usuariomodal.setUsuarioNome(usuario.getUsuario_nome());
	 usuariomodal.setUsuarioUsername(usuario.getUsuario_username());
	 usuariomodal.setUsuarioSenha(senhaEncriptada);
	 usuariomodal.setUsuarioAlterou(usuarioAlterou);
	 usuariomodal.setUsuarioCadastrante(usuarioadm);
	 usuariomodal.setCodPermissao(permissao);
	 repository.save(usuariomodal);
	 
	 ModelAndView modelandview = new ModelAndView();
	 
	 modelandview.addObject("colocar nome da chave do objeto",usuariomodal);
	 modelandview.setViewName("colocar nome da pagina");
    return modelandview;
	 
	 
	 }
	  
    public ModelAndView listar(UsuarioModal usuario) {
    	ModelAndView moden = new ModelAndView();
    	UsuarioModal filtrousuario = repository.findByUsuarioUsername(usuario.getUsuarioUsername());
    	filtrousuario.getCodUsuario();
    	filtrousuario.getUsuarioNome();
    	filtrousuario.getUsuarioUsername();
        moden.addObject("filtrousuario", filtrousuario);
 		moden.setViewName("UsuarioUpUsu");
 		return moden;
    }
}