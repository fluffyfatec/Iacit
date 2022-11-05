package com.fluffyiacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.UsuarioModal;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModal, String> {

	

    UsuarioModal findByusuarioUsername(String usuarioUsername);

	
    
   // @Query("DELETE FROM usuario u WHERE u.usuarioUsername = :usuarioUsername")
 //   UsuarioModal deletedUsuarioUsername (String usuarioUsername);
    


	
}