package br.dev.msp.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.msp.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{
    
}
