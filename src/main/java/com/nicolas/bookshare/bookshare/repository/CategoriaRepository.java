package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Avaliacao;
import com.nicolas.bookshare.bookshare.model.Categoria;
import com.nicolas.bookshare.bookshare.model.Livro;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api
@RepositoryRestResource(path = "anuncios", collectionResourceRel = "anuncios")
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    @Override
    List<Categoria> findAll();

    Categoria findById(@Param("id") Long id);

    List<Categoria> findAllByOrderByNomeAsc();
}
