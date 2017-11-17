package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Avaliacao;
import com.nicolas.bookshare.bookshare.model.Resenha;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AvaliacaoResponseDTO {
    private Boolean sucesso;
    private Date dataExecucao;
    private Avaliacao avaliacao;
    private List<Avaliacao> avaliacoes;

    public AvaliacaoResponseDTO(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public AvaliacaoResponseDTO(Boolean sucesso, Avaliacao avaliacao) {
        this.sucesso = sucesso;
        this.avaliacao = avaliacao;
    }

    public AvaliacaoResponseDTO(Boolean sucesso, List<Avaliacao> avaliacoes) {
        this.sucesso = sucesso;
        this.avaliacoes = avaliacoes;
    }

    public AvaliacaoResponseDTO() {}
}
