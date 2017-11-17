package com.nicolas.bookshare.bookshare.model.request;

import lombok.Data;

@Data
public class ResenhaDTO {
    private String isbn;
    private String tituloResenha;
    private String texto;
    private String username;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTituloResenha() {
        return tituloResenha;
    }

    public void setTituloResenha(String tituloResenha) {
        this.tituloResenha = tituloResenha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
