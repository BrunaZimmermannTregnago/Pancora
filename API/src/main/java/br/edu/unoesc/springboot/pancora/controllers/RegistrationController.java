package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.registration.RegistrationRequest;
import br.edu.unoesc.springboot.pancora.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
