package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.SituacaoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoPacienteRepository extends JpaRepository<SituacaoPaciente, Integer> {
}