package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Usuario;
import com.nicolas.bookshare.bookshare.model.request.UsuarioDTO;
import com.nicolas.bookshare.bookshare.model.response.UsuarioResponseDTO;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UsuarioService {
    final private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO login(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findUsuarioByUsernameAndSenha(usuarioDTO.getUsername(), usuarioDTO.getSenha());

        if (usuario == null) {
            return new UsuarioResponseDTO(false);
        } else {
            return new UsuarioResponseDTO(true, usuario);
        }
    }

    public UsuarioResponseDTO cadastrar(UsuarioDTO usuarioDTO) {
        Usuario usuario;
        try {
            usuario = new Usuario(usuarioDTO.getUsername(), usuarioDTO.getNome(), usuarioDTO.getSobrenome(),
                    usuarioDTO.getEmail(), usuarioDTO.getSenha(), usuarioDTO.getDataNascimento());
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return new UsuarioResponseDTO(false);
        }

        return new UsuarioResponseDTO(true, usuario);
    }

    private Date getDataFromString(String dataNascimento) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(dataNascimento);
    }
}
