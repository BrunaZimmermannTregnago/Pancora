package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.EmpresaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaPacienteRepository extends JpaRepository<EmpresaPaciente, Integer> {
}