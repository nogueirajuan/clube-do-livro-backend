package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Anuncio;
import com.nicolas.bookshare.bookshare.model.request.AnuncioDTO;
import com.nicolas.bookshare.bookshare.model.response.AnuncioResponseDTO;
import com.nicolas.bookshare.bookshare.repository.AnuncioRepository;
import com.nicolas.bookshare.bookshare.repository.LivroRepository;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;
    private final AnuncioRepository anuncioRepository;

    @Autowired
    public AnuncioService(UsuarioRepository usuarioRepository, LivroRepository livroRepository, AnuncioRepository anuncioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
        this.anuncioRepository = anuncioRepository;
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
