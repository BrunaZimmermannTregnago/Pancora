package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.ComorbidadePaciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComorbidadePacienteRepository extends JpaRepository<ComorbidadePaciente, Integer> {
}