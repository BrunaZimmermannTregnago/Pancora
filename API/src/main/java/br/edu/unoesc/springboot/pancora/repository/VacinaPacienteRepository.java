package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.VacinaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaPacienteRepository extends JpaRepository<VacinaPaciente, Integer> {
}