package br.dev.msp.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.msp.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
