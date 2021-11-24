package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Integer> {
}