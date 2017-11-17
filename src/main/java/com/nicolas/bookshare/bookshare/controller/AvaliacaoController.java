package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.Livro;
import com.nicolas.bookshare.bookshare.model.Usuario;
import com.nicolas.bookshare.bookshare.model.request.AvaliacaoDTO;
import com.nicolas.bookshare.bookshare.model.request.CategoriaDTO;
import com.nicolas.bookshare.bookshare.model.response.AvaliacaoResponseDTO;
import com.nicolas.bookshare.bookshare.model.response.CategoriaResponseDTO;
import com.nicolas.bookshare.bookshare.service.AvaliacaoService;
import com.nicolas.bookshare.bookshare.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api("Livros")
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @ApiOperation("Cadastrar avaliacao")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public AvaliacaoResponseDTO cadastrar(
            @RequestParam String isbn, @RequestParam String username, @RequestParam String descricao, @RequestParam Integer avaliacao) {

        AvaliacaoDTO novaAvaliacao = new AvaliacaoDTO();
        novaAvaliacao.setAnunciante(new Usuario(username));
        novaAvaliacao.setAvaliacao(avaliacao);
        novaAvaliacao.setDataPublicacao(new Date());
        novaAvaliacao.setDescricao(descricao);
        novaAvaliacao.setLivro(new Livro(isbn));

        try {
            AvaliacaoResponseDTO cadastrar = avaliacaoService.cadastrar(novaAvaliacao);
            return cadastrar;
        } catch (Exception e) {
            return new AvaliacaoResponseDTO(false);
        }
    }

    @ApiOperation("Encontrar avaliacoes por livro")
    @RequestMapping(value = "/find-by-livro", method = RequestMethod.GET)
    public AvaliacaoResponseDTO findByLivro(@RequestParam String isbn) {

        AvaliacaoResponseDTO avaliacaoResponseDTO = new AvaliacaoResponseDTO();

        try {
            return avaliacaoResponseDTO = avaliacaoService.findByLivro(isbn);
        } catch (Exception e) {
            return new AvaliacaoResponseDTO(false);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public AvaliacaoResponseDTO delete(@RequestParam String id) {

        AvaliacaoResponseDTO result;
        try {
            result = avaliacaoService.delete(Long.parseLong(id));

        } catch (Exception e) {
            return new AvaliacaoResponseDTO(false);
        }

        return result;
    }
}
