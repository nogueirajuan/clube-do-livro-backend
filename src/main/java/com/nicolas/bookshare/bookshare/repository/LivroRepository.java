package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Livro;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api
@RepositoryRestResource(path = "livros", collectionResourceRel = "livros")
public interface LivroRepository extends CrudRepository<Livro, String> {

    @Override
    List<Livro> findAll();

    Livro findLivroByIsbn(String isbn);

    List<Livro> findByTituloLike(@Param("titulo") String titulo);

    List<Livro> findByAutorLike(@Param("autor") String autor);
}
