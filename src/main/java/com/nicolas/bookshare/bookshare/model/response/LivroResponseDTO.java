package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Livro;
import com.nicolas.bookshare.bookshare.model.request.LivroDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class LivroResponseDTO {
    private Boolean sucesso;
    private Date dataExecucao;
    private Livro livro;
    private List<Livro> livros;

    public LivroResponseDTO() {}

    public LivroResponseDTO(Boolean sucesso) {
        this.sucesso = sucesso;
        this.dataExecucao = new Date();
    }

    public LivroResponseDTO(Boolean sucesso, Livro livro) {
        this.sucesso = sucesso;
        this.dataExecucao = new Date();
        this.livro = livro;
    }

    public LivroResponseDTO(Boolean sucesso, List<Livro> livros) {
        this.sucesso = sucesso;
        this.dataExecucao = new Date();
        this.livros = livros;
    }
}
