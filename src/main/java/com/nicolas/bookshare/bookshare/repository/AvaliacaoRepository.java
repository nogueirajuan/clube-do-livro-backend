package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Anuncio;
import com.nicolas.bookshare.bookshare.model.Avaliacao;
import com.nicolas.bookshare.bookshare.model.Livro;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api
@RepositoryRestResource(path = "anuncios", collectionResourceRel = "anuncios")
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

    @Override
    List<Avaliacao> findAll();

    Avaliacao findById(@Param("id") Long id);

    List<Avaliacao> findByLivroOrderByIdDesc(Livro livro);

    List<Avaliacao> findAllByLivro(Livro livro);
}
