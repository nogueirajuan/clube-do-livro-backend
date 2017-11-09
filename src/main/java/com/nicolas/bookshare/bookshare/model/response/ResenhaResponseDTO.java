package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Resenha;
import com.nicolas.bookshare.bookshare.model.request.ResenhaDTO;
import lombok.Data;

import java.util.Date;

@Data
public class ResenhaResponseDTO {
    private Boolean sucesso;
    private Date dataExecucao;
    private Resenha resenha;

    public ResenhaResponseDTO(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public ResenhaResponseDTO(Boolean sucesso, Resenha resenha) {
        this.sucesso = sucesso;
        this.resenha = resenha;
    }

    public ResenhaResponseDTO() {}
}
