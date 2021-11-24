package br.edu.unoesc.springboot.pancora.repository;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.entities.SintomaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SintomaPacienteRepository extends JpaRepository<SintomaPaciente, Integer> {
    @Query(value = "select idsintoma, cpf from SintomaPaciente")
    static List<SintomaPaciente> salvar(int cpf, int idsintoma){
        return null;

    };
}