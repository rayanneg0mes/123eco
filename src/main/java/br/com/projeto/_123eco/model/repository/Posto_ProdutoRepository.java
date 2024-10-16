package br.com.projeto._123eco.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto._123eco.model.entity.Posto_Produto;

@Repository
public interface Posto_ProdutoRepository extends JpaRepository<Posto_Produto, Long> {
	
}