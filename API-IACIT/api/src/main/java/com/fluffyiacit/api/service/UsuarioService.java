package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluffyiacit.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
<<<<<<< Updated upstream
	
	 @Autowired
	 private UsuarioRepository repository;
	 
	 
	 public String delete (Integer codUsuario) {
	        repository.deleteById(codUsuario);
	        return "DELETED";
}
=======

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PermissaoRepository permrepository;

	public ModelAndView criarUsuario(UsuarioDTO usuario) {

		UsuarioModal usuariomodal = new UsuarioModal();

		UsuarioModal usuarioadm = repository.findByusuarioUsername(usuario.getUsuario_adm());

		PermissaoModal permissao = permrepository.findByPermissaoNome(usuario.getNome_permissao());

		usuariomodal.setUsuarioNome(usuario.getUsuario_nome());
		usuariomodal.setUsuarioUsername(usuario.getUsuario_username());
		usuariomodal.setUsuarioSenha(usuario.getUsuario_senha());
		usuariomodal.setUsuarioCadastrante(usuarioadm);
		usuariomodal.setCodPermissao(permissao);

		repository.save(usuariomodal);

		ModelAndView modelandview = new ModelAndView();

		modelandview.addObject("colocar nome da chave do objeto", usuariomodal);
		modelandview.setViewName("colocar nome da pagina");
		return modelandview;

	}

	public void deletar(String usuarioUsername) {
		UsuarioModal usuario = repository.findByusuarioUsername(usuarioUsername);
		repository.delete(usuario);

	}

>>>>>>> Stashed changes
}