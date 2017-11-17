package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Categoria;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CategoriaResponseDTO {
    private Boolean sucesso;
    private Date dataExecucao;
    private Categoria categoria;
    private List<Categoria> categorias;

    public CategoriaResponseDTO(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public CategoriaResponseDTO(Boolean sucesso, Categoria categoria) {
        this.sucesso = sucesso;
        this.categoria = categoria;
    }

    public CategoriaResponseDTO(Boolean sucesso, List<Categoria> categorias) {
        this.sucesso = sucesso;
        this.categorias = categorias;
    }

    public CategoriaResponseDTO() {
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
