package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Resenha;
import com.nicolas.bookshare.bookshare.model.request.ResenhaDTO;
import com.nicolas.bookshare.bookshare.model.response.ResenhaResponseDTO;
import com.nicolas.bookshare.bookshare.repository.LivroRepository;
import com.nicolas.bookshare.bookshare.repository.ResenhaRepository;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenhaService {
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final ResenhaRepository resenhaRepository;

    @Autowired
    public ResenhaService(LivroRepository livroRepository, UsuarioRepository usuarioRepository, ResenhaRepository resenhaRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.resenhaRepository = resenhaRepository;
    }

    public ResenhaResponseDTO cadastrar(ResenhaDTO resenhaDTO) {
        Resenha resenha;
        try {
            resenha = new Resenha(livroRepository.findLivroByIsbn(resenhaDTO.getIsbn()), resenhaDTO.getTituloResenha(),
                    resenhaDTO.getTexto(), usuarioRepository.findUsuarioByUsername(resenhaDTO.getUsername()));
            resenhaRepository.save(resenha);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResenhaResponseDTO(false);
        }

        return new ResenhaResponseDTO(true, resenha);
    }
}
