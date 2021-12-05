package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.registration.RegistrationRequest;
import br.edu.unoesc.springboot.pancora.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller para requisições de cadastro de usuário<br>
 * Esta classe foi construída e adaptada com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Controller
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    /**
     * Mapeia e {@return página de cadastro do usuário}
     */
    @GetMapping
    public String register() {
        return "register";
    }

    /**
     * Mapeia a página de cadastro do usuário e requisita um novo cadastro para a classe RegistrationService
     * @param request objeto da classe Registration Request
     * @return mensagem se o cadastro foi bem sucedido ou não
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<RegistrationRequest> register(@RequestBody RegistrationRequest request){
        registrationService.register(request);
        return new ResponseEntity<RegistrationRequest>(request, HttpStatus.CREATED);
    }
}
