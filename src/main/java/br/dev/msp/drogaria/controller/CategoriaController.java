package br.dev.msp.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.dev.msp.drogaria.domain.Categoria;
import br.dev.msp.drogaria.exception.recursoNaoEncontradoException;
import br.dev.msp.drogaria.repository.CategoriaRepository;
import br.dev.msp.drogaria.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        List<Categoria> categoria = categoriaService.listar();
        return categoria;
    }

    @GetMapping("/{codigo}")
    public Categoria buscarPorCodigo(@PathVariable Short codigo) {

        try{
        Categoria categoria = categoriaService.buscarPorCodigo(codigo);
        return categoria;
        }catch(recursoNaoEncontradoException excecao){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada.", excecao);
        }
    }

    @PostMapping
    public Categoria inserir(@RequestBody Categoria categoria) {
        Categoria categoriaSalvar = categoriaRepository.save(categoria);
        return categoriaSalvar;
    }

    @DeleteMapping("/{codigo}")
    public Optional<Categoria> excluir(@PathVariable Short codigo) {

        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        categoriaRepository.delete(categoria.get());
        return categoria;
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Categoria categoria) {

        Categoria categoriaEditada = categoriaRepository.save(categoria);
        return new ResponseEntity<Categoria>(categoriaEditada, HttpStatus.OK);
    }

}
