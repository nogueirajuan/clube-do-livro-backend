package com.nicolas.bookshare.bookshare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
@Data
public class Livro {
    @Column
    @Id
    @Size(max = 250)
    private String isbn;

    @Column
    @Size(max = 250)
    private String titulo;

    @Column(length = 500)
    @Size(max = 500)
    private String imagem;

    @Column
    @Size(max = 250)
    private String autor;

    @Column(length = 2000)
    private String descricao;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    public Livro() {}

    public Livro(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
