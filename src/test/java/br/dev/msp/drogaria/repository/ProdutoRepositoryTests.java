package br.dev.msp.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.dev.msp.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	public void inserir() {

		Produto p1 = new Produto(null, "Heineken", Byte.valueOf("15"), BigDecimal.valueOf(10, 50),
				LocalDate.of(2022, 12, 20), null);
		Produto p2 = new Produto(null, "Coca Cola", Byte.valueOf("32"), BigDecimal.valueOf(8.0),
				LocalDate.of(2022, 12, 30), null);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
	}
	
}
