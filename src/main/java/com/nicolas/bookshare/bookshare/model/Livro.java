package com.nicolas.bookshare.bookshare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Livro {
    @Column
    @Id
    private String isbn;

    @Column
    private String titulo;

    @Column
    private String imagem;

    @Column
    private String autor;

    @Column
    private String descricao;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataPublicacao;

    public Livro(String isbn, String titulo, String autor, String descricao, String imagem, Date dataPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.imagem = imagem;
    }

    public Livro() {}
}
