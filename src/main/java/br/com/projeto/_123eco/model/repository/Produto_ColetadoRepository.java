package br.com.projeto._123eco.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto._123eco.model.entity.Produto_Coletado;

@Repository
public interface Produto_ColetadoRepository extends JpaRepository<Produto_Coletado, Long> {
}