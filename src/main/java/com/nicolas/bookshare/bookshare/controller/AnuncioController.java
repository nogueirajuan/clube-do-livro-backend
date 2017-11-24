package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.Avaliacao;
import com.nicolas.bookshare.bookshare.model.request.AnuncioDTO;
import com.nicolas.bookshare.bookshare.model.response.AnuncioResponseDTO;
import com.nicolas.bookshare.bookshare.repository.AnuncioRepository;
import com.nicolas.bookshare.bookshare.repository.AvaliacaoRepository;
import com.nicolas.bookshare.bookshare.service.AnuncioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Anúncios")
@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
    private final AnuncioService anuncioService;
    private final AnuncioRepository anuncioRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AnuncioController(AnuncioService anuncioService, AnuncioRepository anuncioRepository, AvaliacaoRepository avaliacaoRepository) {
        this.anuncioService = anuncioService;
        this.anuncioRepository = anuncioRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @ApiOperation("Cadastrar um novo anúncio")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public AnuncioResponseDTO cadastrar(@RequestParam String anunciante,
                                        @RequestParam String descricao,
                                        @RequestParam String livroID) {

        AnuncioDTO anuncioDTO = new AnuncioDTO();
        anuncioDTO.setAnunciante(anunciante);
        anuncioDTO.setDescricao(descricao);
        anuncioDTO.setLivroIsbn(livroID);

        return anuncioService.cadastrar(anuncioDTO);
    }

    @ApiOperation("Listar anuncios")
    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public AnuncioResponseDTO findAll() {

        AnuncioResponseDTO result;
        try {
            result = new AnuncioResponseDTO(true, anuncioService.findAll());
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-all-by-name", method = RequestMethod.GET)
    public AnuncioResponseDTO findAll(String nome) {

        AnuncioResponseDTO result;
        try {
            result = new AnuncioResponseDTO(true, anuncioService.findAll());
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-by-username", method = RequestMethod.GET)
    public AnuncioResponseDTO findByUsername(String username) {

        AnuncioResponseDTO result;
        try {
            result = new AnuncioResponseDTO(true, anuncioService.findByUsername(username));
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-all-by-isbn", method = RequestMethod.GET)
    public AnuncioResponseDTO findAllByIsbn(String isbn) {

        AnuncioResponseDTO result;
        try {
            result = new AnuncioResponseDTO(true, anuncioService.findAll());
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-all-by-username", method = RequestMethod.GET)
    public AnuncioResponseDTO findAllByUsername(String username) {

        AnuncioResponseDTO result;
        try {
            result = new AnuncioResponseDTO(true, anuncioService.findAll());
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-by-id", method = RequestMethod.GET)
    public AnuncioResponseDTO findById(Long id) {

        AnuncioResponseDTO result;
        try {
            result = new AnuncioResponseDTO(true, anuncioService.findById(id));
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-by-like-book-name", method = RequestMethod.GET)
    public AnuncioResponseDTO findByLikeBookName(String bookName) {

        AnuncioResponseDTO result;
        try {
            result = anuncioService.findByLikeBookName(bookName);
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/find-all-by-category", method = RequestMethod.GET)
    public AnuncioResponseDTO findAllByCategoryId(Long idCategoria) {

        AnuncioResponseDTO result;
        List<Avaliacao> avaliacoes;
        try {
            result = anuncioService.findAllByCategoria(idCategoria);
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void delete(Long id) {

        AnuncioResponseDTO result;
        try {
            anuncioService.delete(id);
        } catch (Exception e) {
            result = new AnuncioResponseDTO(false);
        }
    }
}
