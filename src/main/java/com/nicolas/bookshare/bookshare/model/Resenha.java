package com.nicolas.bookshare.bookshare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Resenha {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Livro livro;

    @Column
    private String titulo;

    @Column
    private String texto;

    @ManyToOne
    private Usuario autor;

    public Resenha(Livro livro, String titulo, String texto, Usuario autor) {
        this.livro = livro;
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
    }

    public Resenha() {}
}
