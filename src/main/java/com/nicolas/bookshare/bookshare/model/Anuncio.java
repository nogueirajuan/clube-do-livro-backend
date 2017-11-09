package com.nicolas.bookshare.bookshare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Anuncio {
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

    @Column
    private Long valor;

    public Anuncio(Livro livro, Usuario anunciante, String descricao, Long valor) {
        this.livro = livro;
        this.anunciante = anunciante;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Anuncio() {}
}
