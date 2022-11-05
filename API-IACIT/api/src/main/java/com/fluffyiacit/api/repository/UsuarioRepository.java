package com.fluffyiacit.api.repository;

<<<<<<< Updated upstream
=======
import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
>>>>>>> Stashed changes
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fluffyiacit.api.modal.UsuarioModal;


@Repository
<<<<<<< Updated upstream
public interface UsuarioRepository extends CrudRepository<UsuarioModal, Integer> {

}
=======
public interface UsuarioRepository extends JpaRepository<UsuarioModal, String> {

	

    UsuarioModal findByusuarioUsername(String usuarioUsername);

	
    
   // @Query("DELETE FROM usuario u WHERE u.usuarioUsername = :usuarioUsername")
 //   UsuarioModal deletedUsuarioUsername (String usuarioUsername);
    


	
}
>>>>>>> Stashed changes
