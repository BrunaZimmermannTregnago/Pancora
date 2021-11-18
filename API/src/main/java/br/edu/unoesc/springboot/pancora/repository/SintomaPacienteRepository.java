package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.SintomaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SintomaPacienteRepository extends JpaRepository<SintomaPaciente, Integer> {
}