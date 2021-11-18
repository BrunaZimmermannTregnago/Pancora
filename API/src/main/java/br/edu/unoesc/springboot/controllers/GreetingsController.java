package br.edu.unoesc.springboot.controllers;

import br.edu.unoesc.springboot.pancora.entities.Situacao;
import br.edu.unoesc.springboot.pancora.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }

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
}
