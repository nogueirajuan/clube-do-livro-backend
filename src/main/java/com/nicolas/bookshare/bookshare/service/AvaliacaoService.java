package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Avaliacao;
import com.nicolas.bookshare.bookshare.model.Livro;
import com.nicolas.bookshare.bookshare.model.Resenha;
import com.nicolas.bookshare.bookshare.model.request.AvaliacaoDTO;
import com.nicolas.bookshare.bookshare.model.request.ResenhaDTO;
import com.nicolas.bookshare.bookshare.model.response.AvaliacaoResponseDTO;
import com.nicolas.bookshare.bookshare.model.response.ResenhaResponseDTO;
import com.nicolas.bookshare.bookshare.repository.AvaliacaoRepository;
import com.nicolas.bookshare.bookshare.repository.LivroRepository;
import com.nicolas.bookshare.bookshare.repository.ResenhaRepository;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoResponseDTO cadastrar(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao;
        try {
            avaliacao = new Avaliacao();
            avaliacao.setAnunciante(avaliacaoDTO.getAnunciante());
            avaliacao.setAvaliacao(avaliacaoDTO.getAvaliacao());
            avaliacao.setDataPublicacao(avaliacaoDTO.getDataPublicacao());
            avaliacao.setDescricao(avaliacaoDTO.getDescricao());
            avaliacao.setLivro(avaliacaoDTO.getLivro());

            avaliacaoRepository.save(avaliacao);

        } catch (Exception e) {
            e.printStackTrace();
            return new AvaliacaoResponseDTO(false);
        }

        return new AvaliacaoResponseDTO(true, avaliacao);
    }

    public AvaliacaoResponseDTO delete(Long id) {
        Avaliacao avaliacao;
        try {
            avaliacao = new Avaliacao();
            avaliacao.setId(id);

            avaliacaoRepository.delete(avaliacao);

        } catch (Exception e) {
            e.printStackTrace();
            return new AvaliacaoResponseDTO(false);
        }

        return new AvaliacaoResponseDTO(true, avaliacao);
    }


    public AvaliacaoResponseDTO findByLivro(String isbn) {

        try {
            return new AvaliacaoResponseDTO(true, avaliacaoRepository.findByLivroOrderByIdDesc(new Livro(isbn)));
        } catch (Exception e) {
            return new AvaliacaoResponseDTO(false);
        }

    }
}
