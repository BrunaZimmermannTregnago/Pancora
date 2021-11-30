package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.entities.SintomaPaciente;
import br.edu.unoesc.springboot.pancora.repository.PacienteRepository;
import br.edu.unoesc.springboot.pancora.repository.SintomaPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired // injeção de dependência
    private PacienteRepository pacienteRepository;
    @RequestMapping(value = "/lista-pacientes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Paciente>>buscar(){
        List<Paciente> paciente = pacienteRepository.buscar();
        if(paciente != null){
            return new ResponseEntity<List<Paciente>>(paciente, HttpStatus.OK);
        }else{
            System.out.println("Não há dados.");
            return null;
        }
    }

    @Autowired // injeção de dependência
    private SintomaPacienteRepository sintomaPacienteRepository;
    @RequestMapping(value = "/salvar-sintomaPaciente/{cpf}/{idsintoma}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<SintomaPaciente>>salvar(int cpf, int idsintoma){
        List<SintomaPaciente> sintomaPaciente = SintomaPacienteRepository.salvar(cpf, idsintoma);
            return new ResponseEntity<List<SintomaPaciente>>(sintomaPaciente, HttpStatus.OK);

    }
}
