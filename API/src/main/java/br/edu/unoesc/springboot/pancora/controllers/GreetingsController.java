package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.entities.SintomaPaciente;
import br.edu.unoesc.springboot.pancora.entities.Situacao;
import br.edu.unoesc.springboot.pancora.repository.PacienteRepository;
import br.edu.unoesc.springboot.pancora.repository.SintomaPacienteRepository;
import br.edu.unoesc.springboot.pancora.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

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
//
//    @Autowired // injeção de dependência
//    private SituacaoRepository situacaoRepository;
//    @RequestMapping(value = "testeGravar/{situacao}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String testeGravar(@PathVariable String situacao){
//        Situacao novaSituacao = new Situacao();
//        novaSituacao.setSituacao(situacao);
//        situacaoRepository.save(novaSituacao);
//        return "Gravado";
//    }


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

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