package br.edu.unoesc.springboot.pancora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller para requisições de login
 */
@Controller
public class LoginController {

    /**
     * Mapeia e {@return página de login}
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
