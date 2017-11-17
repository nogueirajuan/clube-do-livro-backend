package com.nicolas.bookshare.bookshare.service;

import com.nicolas.bookshare.bookshare.model.Categoria;
import com.nicolas.bookshare.bookshare.model.Usuario;
import com.nicolas.bookshare.bookshare.model.request.CategoriaDTO;
import com.nicolas.bookshare.bookshare.model.request.UsuarioDTO;
import com.nicolas.bookshare.bookshare.model.response.CategoriaResponseDTO;
import com.nicolas.bookshare.bookshare.model.response.UsuarioResponseDTO;
import com.nicolas.bookshare.bookshare.repository.CategoriaRepository;
import com.nicolas.bookshare.bookshare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO cadastrar(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        try {
            categoria.setNome(categoriaDTO.getNome());
            categoriaRepository.save(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return new CategoriaResponseDTO(false);
        }

        return new CategoriaResponseDTO(true, categoria);
    }

    public CategoriaResponseDTO delete(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        try {
            categoria.setNome(categoriaDTO.getNome());
            categoria.setId(categoriaDTO.getId());
            categoriaRepository.delete(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return new CategoriaResponseDTO(false);
        }

        return new CategoriaResponseDTO(true, categoria);
    }
}
