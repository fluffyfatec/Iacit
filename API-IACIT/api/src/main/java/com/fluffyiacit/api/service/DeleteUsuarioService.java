package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repository.UsuarioDeleteRepository;



@Service
public class DeleteUsuarioService {

	@Autowired
	private UsuarioDeleteRepository repository;

	public void deletar(String usuarioUsername) {
		UsuarioModal usuario = repository.findByusuarioUsername(usuarioUsername);		
	    repository.delete(usuario);

	}

}