package br.edu.unoesc.springboot.controllers;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.entities.Situacao;
import br.edu.unoesc.springboot.pancora.repository.PacienteRepository;
import br.edu.unoesc.springboot.pancora.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String greetingText(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }

    @Autowired // injeção de dependência
    private SituacaoRepository situacaoRepository;
    @RequestMapping(value = "testeGravar/{situacao}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String testeGravar(@PathVariable String situacao){
        Situacao novaSituacao = new Situacao();
        novaSituacao.setSituacao(situacao);
        situacaoRepository.save(novaSituacao);
        return "Gravado";
    }

    @Autowired // injeção de dependência
    private PacienteRepository pacienteRepository;
    @RequestMapping(value = "/lista-pacientes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Paciente>>buscar(){
        List<Paciente> paciente = pacienteRepository.buscar("jose");
        if(paciente != null){
            return new ResponseEntity<List<Paciente>>(paciente, HttpStatus.OK);
        }else{
            System.out.println("Não há dados.");
        }
    return null;
    }

//    @GetMapping("/teste-paciente")
//    public String lista-paciente() {
//        return "lista-paciente";
//    }
}
