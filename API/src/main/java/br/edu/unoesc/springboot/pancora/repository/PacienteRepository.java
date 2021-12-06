package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, BigDecimal> {

    @Query(value = "select p from Paciente p")
    List<Paciente> buscar();
//
//    @Query(value = "select p.cpf from Paciente p where usuario = ?1")
//    BigDecimal getCpfByUser(Long id);
}