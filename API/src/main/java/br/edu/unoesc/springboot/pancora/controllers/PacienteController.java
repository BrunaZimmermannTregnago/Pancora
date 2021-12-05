package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Controller para requisições relacionadas ao paciente
 */
@Controller
public class PacienteController {

    /**
     * Mapeia a página de listagem de pacientes e retorna a lista, caso exista
     */
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

    /**
     * Mapeia e retorna a página do usuário
     */
    @GetMapping("/usuario")
    public String usuario() {
        return "usuario";
    }
}
