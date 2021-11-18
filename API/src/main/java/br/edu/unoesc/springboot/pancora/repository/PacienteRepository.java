package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PacienteRepository extends JpaRepository<Paciente, BigDecimal> {
}