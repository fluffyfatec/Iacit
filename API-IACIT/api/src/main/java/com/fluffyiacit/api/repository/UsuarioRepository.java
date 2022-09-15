package com.fluffyiacit.api.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.UsuarioModal;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModal, Integer>{

}


