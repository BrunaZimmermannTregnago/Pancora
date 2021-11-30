package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.registration.RegistrationRequest;
import br.edu.unoesc.springboot.pancora.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @GetMapping
    public String register() {
        return "register";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<RegistrationRequest> register(@RequestBody RegistrationRequest request){
        registrationService.register(request);
        return new ResponseEntity<RegistrationRequest>(request, HttpStatus.CREATED);
    }
}
