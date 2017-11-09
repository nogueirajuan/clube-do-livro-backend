package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Usuario;
import com.nicolas.bookshare.bookshare.model.request.UsuarioDTO;
import lombok.Data;

import java.util.Date;

@Data
public class UsuarioResponseDTO {
    private Boolean sucesso;
    private Date dataExecucao;
    private Usuario usuario;

    public UsuarioResponseDTO() {}

    public UsuarioResponseDTO(Boolean sucesso) {
        this.sucesso = sucesso;
        this.dataExecucao = new Date();
    }

    public UsuarioResponseDTO(Boolean sucesso, Usuario usuario) {
        this.sucesso = sucesso;
        this.dataExecucao = new Date();
        this.usuario = usuario;
        this.usuario.setSenha(null);
    }
}
