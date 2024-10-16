package br.com.projeto._123eco.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto._123eco.model.entity.PostoDeColeta;

@Repository
public interface PostoDeColetaRepository extends JpaRepository<PostoDeColeta, Long> {
}