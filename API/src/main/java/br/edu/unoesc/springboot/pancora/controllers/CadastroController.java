package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.entities.Empresa;
import br.edu.unoesc.springboot.pancora.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CadastroController {

    @Autowired
    private final EmpresaRepository empresaRepository;

    public CadastroController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    @GetMapping("/cadastro-paciente")
    public String cadastroPaciente() {
        return "cadastro-paciente";
    }

    @GetMapping("/cadastro-empresa")
    public String cadastroEmpresa() {
        return "cadastro-empresa";
    }

    @PostMapping("/cadastro-empresa")
    @ResponseBody
    public ResponseEntity<Empresa> cadastraEmpresa(@RequestBody Empresa empresa){
        Empresa empresaSalva = empresaRepository.save(empresa);
        return new ResponseEntity<Empresa>(empresaSalva, HttpStatus.CREATED);
    }

    @GetMapping("cadastro-sintomas")
    public String cadastroSintomas() {
        return "cadastro-sintomas";
    }
}
