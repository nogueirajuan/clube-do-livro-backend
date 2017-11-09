package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Resenha;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api
@RepositoryRestResource(path = "resenhas", collectionResourceRel = "resenhas")
public interface ResenhaRepository extends CrudRepository<Resenha, Long> {
    Resenha findById(@Param("id") Long id);
    List<Resenha> findByLivro_Isbn(@Param("isbn") String isbn);
    List<Resenha> findByTitulo_Like(@Param("titulo") String isbn);
    List<Resenha> findByAutor_Username(@Param("username") String isbn);
}
