package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Anuncio;
import com.nicolas.bookshare.bookshare.model.request.AnuncioDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AnuncioResponseDTO {
    private Boolean sucesso;
    private Date dataExecucao;
    private Anuncio anuncio;
    private List<Anuncio> anuncios;

    public AnuncioResponseDTO(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public AnuncioResponseDTO(Boolean sucesso, Anuncio anuncio) {
        this.sucesso = sucesso;
        this.anuncio = anuncio;
    }

    public AnuncioResponseDTO(Boolean sucesso, List<Anuncio> anuncio) {
        this.sucesso = sucesso;
        this.anuncios = anuncio;
    }

    public AnuncioResponseDTO() {}
}
