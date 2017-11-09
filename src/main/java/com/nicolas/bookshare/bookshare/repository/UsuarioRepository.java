package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Usuario;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Api
@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findUsuarioByUsernameAndSenha(@Param("username") String username, @Param("senha") String senha);
    Usuario findUsuarioByUsername(@Param("username") String username);
    Usuario findUsuarioByEmail(@Param("email") String email);
}
