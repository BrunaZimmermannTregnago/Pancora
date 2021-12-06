package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.appuser.AppUser;
import br.edu.unoesc.springboot.pancora.appuser.AppUserRepository;
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

    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Mapeia e {@return página index}
     */
    @GetMapping("/lista-paciente")
    public String listaPaciente() {
        return "lista-paciente";
    }

    /**
     * Mapeia a página de listagem de pacientes e retorna a lista, caso exista
     */
    @GetMapping(value = "listar-paciente")
    @ResponseBody
    public ResponseEntity<List<Paciente>>listarPaciente(){
        List<Paciente> paciente = pacienteRepository.buscar();
        if(paciente != null){
            return new ResponseEntity<List<Paciente>>(paciente, HttpStatus.OK);
        }else{
            System.out.println("Não há dados.");
            return null;
        }
    }

    @Autowired
    private AppUserRepository appUserRepository;

    /**
     * Mapeia e retorna a página do usuário
     */
    @GetMapping("/usuario")
    public String usuario() {
        return "usuario";
    }

    /**
     * Mapeia a página de listagem de usuario e retorna a lista, caso exista
     */
    @GetMapping(value = "listar-usuario")
    @ResponseBody
    public ResponseEntity<List<AppUser>> listarUsuario(){
        List<AppUser> usuario = appUserRepository.buscar();
        if(usuario != null){
            return new ResponseEntity<List<AppUser>>(usuario, HttpStatus.OK);
        }else{
            System.out.println("Não há dados.");
            return null;
        }
    }
}
