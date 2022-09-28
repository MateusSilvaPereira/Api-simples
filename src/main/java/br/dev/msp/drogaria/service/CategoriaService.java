package br.dev.msp.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.dev.msp.drogaria.domain.Categoria;
import br.dev.msp.drogaria.exception.recursoNaoEncontradoException;
import br.dev.msp.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;

    public Categoria buscarPorCodigo(Short codigo) {

        Optional<Categoria> resultado = categoriaRepository.findById(codigo);
        if (resultado.isEmpty()) {
            throw new recursoNaoEncontradoException();
        } else {
            Categoria categoria = resultado.get();
            return categoria;
        }
    }

    public List<Categoria> listar(){
        List<Categoria> resultado = categoriaRepository.findAll();
        return resultado;
    }
}
