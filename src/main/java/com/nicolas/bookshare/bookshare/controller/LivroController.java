package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.Livro;
import com.nicolas.bookshare.bookshare.model.request.LivroDTO;
import com.nicolas.bookshare.bookshare.model.response.LivroResponseDTO;
import com.nicolas.bookshare.bookshare.repository.LivroRepository;
import com.nicolas.bookshare.bookshare.service.AnuncioService;
import com.nicolas.bookshare.bookshare.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api("Livros")
@RestController
@RequestMapping("/livros")
public class LivroController {

    final private LivroService livroService;
    final private LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroService livroService, LivroRepository livroRepository) {
        this.livroService = livroService;
        this.livroRepository = livroRepository;
    }

    @Autowired
    AnuncioService anuncioService;

    @ApiOperation("Cadastrar um livro")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public LivroResponseDTO cadastrar(@RequestParam String autor,
                                      @RequestParam String descricao,
                                      @RequestParam(defaultValue = "imgs/sem-imagem.jpg", required = false) String imagem,
                                      @RequestParam String isbn,
                                      @RequestParam String titulo,
                                      @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataPublicacao) {

        LivroResponseDTO livroResponseDTO = new LivroResponseDTO();

        LivroDTO novoLivro = new LivroDTO();
        novoLivro.setAutor(autor);
        novoLivro.setDataPublicacao(dataPublicacao);
        novoLivro.setDescricao(descricao);
        novoLivro.setIsbn(isbn);
        novoLivro.setTitulo(titulo);
        novoLivro.setImagem(imagem);

        try {
            livroResponseDTO = livroService.cadastrar(novoLivro);
            return livroResponseDTO;
        } catch (Exception e) {
            livroResponseDTO = new LivroResponseDTO(false);
            return livroResponseDTO;
        }

    }


    @ApiOperation("Encontrar livros")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public LivroResponseDTO findAll(@RequestBody LivroDTO livroDTO) {
        LivroResponseDTO result;
        try {
            result = new LivroResponseDTO(true, livroService.findAll());
            return result;
        } catch (Exception e) {
            result = new LivroResponseDTO(false);
            return result;
        }
    }

    @ApiOperation("Encontrar livro por id")
    @RequestMapping(value = "/find-by-id", method = RequestMethod.POST)
    public LivroResponseDTO findById(@RequestBody String id) {
        LivroResponseDTO result;
        try {
            result = new LivroResponseDTO(true, livroService.findById(id));
            return result;
        } catch (Exception e) {
            result = new LivroResponseDTO(false);
            return result;
        }
    }
}
