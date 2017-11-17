package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.request.CategoriaDTO;
import com.nicolas.bookshare.bookshare.model.response.CategoriaResponseDTO;
import com.nicolas.bookshare.bookshare.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("Livros")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @ApiOperation("Cadastrar categoria")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public CategoriaResponseDTO cadastrar(
            @RequestParam String nome) {

        CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO();

        CategoriaDTO novaCategoria = new CategoriaDTO();
        novaCategoria.setNome(nome);

        try {
            return categoriaResponseDTO = categoriaService.cadastrar(novaCategoria);
        } catch (Exception e) {
            return new CategoriaResponseDTO(false);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(String id) {

        CategoriaResponseDTO result;
        try {

            CategoriaDTO categoria = new CategoriaDTO();
            categoria.setId(Long.parseLong(id));

            categoriaService.delete(categoria);

        } catch (Exception e) {
            result = new CategoriaResponseDTO(false);
        }
    }
}
