package com.nicolas.bookshare.bookshare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Categoria {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String categoria) {
        this.nome = categoria;
    }
}
