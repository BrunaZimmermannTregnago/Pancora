package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SintomaRepository extends JpaRepository<Sintoma, Integer> {
}