package com.nicolas.bookshare.bookshare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Avaliacao {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Livro livro;

    @ManyToOne
    private Usuario anunciante;

    @Column
    private String descricao;

    public Avaliacao(Livro livro, Usuario anunciante, String descricao) {
        this.livro = livro;
        this.anunciante = anunciante;
        this.descricao = descricao;
    }

    public Avaliacao() {}

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
}
