package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Anuncio;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api
@RepositoryRestResource(path = "anuncios", collectionResourceRel = "anuncios")
public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

    @Override
    List<Anuncio> findAll();

    Anuncio findById(@Param("id")Long id);
    List<Anuncio> findByLivro_Isbn(@Param("isbn") String isbn);
    List<Anuncio> findByAnunciante_Username(@Param("username") String username);

    @Query("select anuncio from Anuncio anuncio where LOWER(anuncio.livro.titulo) like lower(concat('%', :bookName,'%'))")
    List<Anuncio> findByLikeBookName(@Param("bookName") String bookName);

    @Query("select anuncio from Anuncio anuncio where anuncio.livro.categoria.id = :IDCATEGORIA")
    List<Anuncio> findByCategoriaLivro(@Param("IDCATEGORIA") Long idCategoria);
}
