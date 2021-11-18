package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Comorbidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Integer> {
}