package br.edu.unoesc.springboot.pancora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller para requisições da página index
 */
@Controller
public class IndexController {

    /**
     * Mapeia e {@return página index}
     */
    @GetMapping("/index")
    public String login() {
        return "index";
    }

}
