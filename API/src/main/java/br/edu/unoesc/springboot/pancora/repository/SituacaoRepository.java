package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoRepository extends JpaRepository<Situacao, Integer> {
}