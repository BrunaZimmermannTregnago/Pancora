package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.entities.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SintomaRepository extends JpaRepository<Sintoma, Integer> {

}