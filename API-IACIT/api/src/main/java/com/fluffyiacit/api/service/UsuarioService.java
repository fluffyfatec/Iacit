package com.fluffyiacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluffyiacit.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	 @Autowired
	 private UsuarioRepository repository;
	 
	 
	 public String delete (Integer codUsuario) {
	        repository.deleteById(codUsuario);
	        return "DELETED";
}
}