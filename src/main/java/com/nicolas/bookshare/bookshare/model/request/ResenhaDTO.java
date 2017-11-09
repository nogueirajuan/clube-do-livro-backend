package com.nicolas.bookshare.bookshare.model.request;

import lombok.Data;

@Data
public class ResenhaDTO {
    private String isbn;
    private String tituloResenha;
    private String texto;
    private String username;
}
