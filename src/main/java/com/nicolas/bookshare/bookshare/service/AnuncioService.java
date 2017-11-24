package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Anuncio;
import com.nicolas.bookshare.bookshare.model.Avaliacao;
import com.nicolas.bookshare.bookshare.model.request.AnuncioDTO;
import com.nicolas.bookshare.bookshare.model.response.AnuncioResponseDTO;
import com.nicolas.bookshare.bookshare.repository.AnuncioRepository;
import com.nicolas.bookshare.bookshare.repository.AvaliacaoRepository;
import com.nicolas.bookshare.bookshare.repository.LivroRepository;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AnuncioService {
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;
    private final AnuncioRepository anuncioRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AnuncioService(UsuarioRepository usuarioRepository, LivroRepository livroRepository, AnuncioRepository anuncioRepository, AvaliacaoRepository avaliacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
        this.anuncioRepository = anuncioRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Anuncio> findAll(){
        return anuncioRepository.findAll();
    }


    public Anuncio findById(Long id){
        return anuncioRepository.findById(id);
    }

    public List<Anuncio> findByUsername(String username){
        return anuncioRepository.findByAnunciante_Username(username);
    }

    public AnuncioResponseDTO findByLikeBookName(String bookName){
        List<Anuncio> anuncios;
        try {
            anuncios = anuncioRepository.findByLikeBookName(bookName);

        } catch (Exception e) {
            e.printStackTrace();
            return new AnuncioResponseDTO(false);
        }

        return new AnuncioResponseDTO(true, anuncios);
    }

    public AnuncioResponseDTO findAllByCategoria(Long idCategoria){
        List<Anuncio> anuncios;
        try {
            anuncios = anuncioRepository.findByCategoriaLivro(idCategoria);
            for (Anuncio anuncio : anuncios) {
                List<Avaliacao> avaliacoes = avaliacaoRepository.findAllByLivro(anuncio.getLivro());
                float media = 0;
                for (Avaliacao avaliacao : avaliacoes) {
                    media += avaliacao.getAvaliacao();
                }
                media = media/avaliacoes.size();
                anuncio.getLivro().setMediaAvaliacoes(media);
                System.out.println("Média do livro " + anuncio.getLivro().getTitulo() + ": " + media);
            }
            anuncios.forEach(System.out::println);
            anuncios.sort(Comparator.comparing(anuncio -> anuncio.getLivro().getMediaAvaliacoes()));
            Collections.reverse(anuncios);
            anuncios.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            return new AnuncioResponseDTO(false);
        }

        return new AnuncioResponseDTO(true, anuncios);
    }

    public AnuncioResponseDTO cadastrar(AnuncioDTO anuncioDTO) {
        Anuncio anuncio;
        try {
            anuncio = new Anuncio(livroRepository.findLivroByIsbn(anuncioDTO.getLivroIsbn()),
                    usuarioRepository.findUsuarioByUsername(anuncioDTO.getAnunciante()), anuncioDTO.getDescricao(),
                    anuncioDTO.getValor());
            anuncioRepository.save(anuncio);
        } catch (Exception e) {
            e.printStackTrace();
            return new AnuncioResponseDTO(false);
        }

        return new AnuncioResponseDTO(true, anuncio);
    }

    public void delete(Long id){
        anuncioRepository.delete(id);
    }
}
