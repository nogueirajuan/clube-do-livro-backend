package com.nicolas.bookshare.bookshare.model.request;

import com.nicolas.bookshare.bookshare.model.Livro;
import com.nicolas.bookshare.bookshare.model.Usuario;
import lombok.Data;

import java.util.Date;

@Data
public class AvaliacaoDTO {
    private Long id;
    private Livro livro;
    private Usuario anunciante;
    private String descricao;
    private Integer avaliacao;
    private Date dataPublicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Usuario anunciante) {
        this.anunciante = anunciante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
