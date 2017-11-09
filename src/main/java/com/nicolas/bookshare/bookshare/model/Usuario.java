package com.nicolas.bookshare.bookshare.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class Usuario {
    @Id
    @Column
    private String username;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private Date dataNascimento;

    public Usuario(String username, String nome, String sobrenome, String email, String senha, Date dataNascimento) {
        this.username = username;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {}
}
