package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Livro;
import com.nicolas.bookshare.bookshare.model.request.LivroDTO;
import com.nicolas.bookshare.bookshare.model.response.LivroResponseDTO;
import com.nicolas.bookshare.bookshare.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    final private LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(String id){
        return livroRepository.findOne(id);
    }

    public LivroResponseDTO cadastrar(LivroDTO livroDTO) {
        Livro livro = new Livro();
        try {
            livro.setIsbn(livroDTO.getIsbn());
            livro.setTitulo(livroDTO.getTitulo());
            livro.setDescricao(livroDTO.getDescricao());
            livro.setImagem(livroDTO.getImagem());
            livro.setDataPublicacao(livroDTO.getDataPublicacao());
            livro.setAutor(livroDTO.getAutor());
            livro.setCategoria(livroDTO.getCategoria());

            livroRepository.save(livro);
        } catch (Exception e) {
            e.printStackTrace();
            return new LivroResponseDTO(false);
        }

        return new LivroResponseDTO(true, livro);
    }

    public void delete(String id){
        livroRepository.delete(id);
    }
}
