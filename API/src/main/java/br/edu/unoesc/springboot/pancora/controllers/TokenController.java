package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para requisições de confirmação de email<br>
 * Esta classe foi construída e adaptada com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class TokenController {

    private RegistrationService registrationService;

    /**
     * Mapeia a página de confirmação de email
     * @param token token exibido na url
     * @return mensagem se o token foi confirmado ou se houve algum problema
     */
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
