package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.request.UsuarioDTO;
import com.nicolas.bookshare.bookshare.model.response.UsuarioResponseDTO;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import com.nicolas.bookshare.bookshare.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api("Usuários")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    final private UsuarioService usuarioService;
    final private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @ApiOperation("Fazer login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UsuarioResponseDTO login(@RequestParam String username, @RequestParam String password) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setUsername(username);
        usuarioDTO.setSenha(password);

        return usuarioService.login(usuarioDTO);
    }

    @ApiOperation("Cadastrar usuário")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public UsuarioResponseDTO cadastrar(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataNascimento,
                                        @RequestParam String email,
                                        @RequestParam String nome,
                                        @RequestParam String sobrenome,
                                        @RequestParam String username,
                                        @RequestParam String senha) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setSenha(senha);
        usuarioDTO.setUsername(username);
        usuarioDTO.setDataNascimento(dataNascimento);
        usuarioDTO.setEmail(email);
        usuarioDTO.setNome(nome);
        usuarioDTO.setSobrenome(sobrenome);

        return usuarioService.cadastrar(usuarioDTO);
    }
}
