package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.Resenha;
import com.nicolas.bookshare.bookshare.model.request.ResenhaDTO;
import com.nicolas.bookshare.bookshare.model.response.ResenhaResponseDTO;
import com.nicolas.bookshare.bookshare.repository.ResenhaRepository;
import com.nicolas.bookshare.bookshare.service.ResenhaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Resenhas")
@RestController
@RequestMapping("/resenhas")
public class ResenhaController {
    private final ResenhaService resenhaService;
    private final ResenhaRepository resenhaRepository;

    @Autowired
    public ResenhaController(ResenhaService resenhaService, ResenhaRepository resenhaRepository) {
        this.resenhaService = resenhaService;
        this.resenhaRepository = resenhaRepository;
    }

    @ApiOperation("Salvar uma resenha")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResenhaResponseDTO cadastrar(@RequestBody ResenhaDTO resenhaDTO) {
        return resenhaService.cadastrar(resenhaDTO);
    }
}
