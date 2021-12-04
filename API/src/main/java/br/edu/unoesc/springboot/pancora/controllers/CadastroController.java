package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.dto.EmpresaDTO;
import br.edu.unoesc.springboot.pancora.dto.PacienteDTO;
import br.edu.unoesc.springboot.pancora.dto.SintomaPacienteDTO;
import br.edu.unoesc.springboot.pancora.entities.Empresa;
import br.edu.unoesc.springboot.pancora.entities.Paciente;
import br.edu.unoesc.springboot.pancora.entities.SintomaPaciente;
import br.edu.unoesc.springboot.pancora.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
public class CadastroController {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private SintomaRepository sintomaRepository;
    @Autowired
    private SintomaPacienteRepository sintomaPacienteRepository;

    @GetMapping("/cadastro-paciente")
    public String cadastroPaciente() {
        return "cadastro-paciente";
    }

    @PostMapping("/cadastro-paciente")
    @ResponseBody
    public ResponseEntity<Paciente> cadastraPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteDTO.getPaciente();
        paciente.setBairroId(bairroRepository.findById(pacienteDTO.getBairroId()).get());
        paciente.setCidadeId(cidadeRepository.findById(pacienteDTO.getCidadeId()).get());
        paciente.setTipoUsuarioId(tipoUsuarioRepository.findById(pacienteDTO.getTipoUsuarioId()).get());

        pacienteRepository.save(paciente);
        return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
    }

    @GetMapping("/cadastro-empresa")
    public String cadastroEmpresa() {
        return "cadastro-empresa";
    }

    @PostMapping("/cadastro-empresa")
    @ResponseBody
    public ResponseEntity<Empresa> cadastraEmpresa(@RequestBody EmpresaDTO empresaDTO){
        Empresa empresa = empresaDTO.getEmpresa();
        empresa.setBairroId(bairroRepository.findById(empresaDTO.getBairroId()).get());
        empresa.setCidadeId(cidadeRepository.findById(empresaDTO.getCidadeId()).get());

        empresaRepository.save(empresa);
        return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
    }

    @GetMapping("cadastro-sintoma")
    public String cadastroSintoma() {
        return "cadastro-sintoma";
    }

    @PostMapping("/cadastro-sintoma")
    @ResponseBody
    public ResponseEntity<SintomaPaciente> cadastraSintomaPaciente(@RequestBody SintomaPacienteDTO sintomaPacienteDTO){
        SintomaPaciente sintomaPaciente = sintomaPacienteDTO.getSintomaPaciente();
        sintomaPaciente.setCpf(pacienteRepository.findById(sintomaPacienteDTO.getCpf()).get());
        sintomaPaciente.setSintomaId(sintomaRepository.findById(sintomaPacienteDTO.getSintomaId()).get());

        sintomaPacienteRepository.save(sintomaPaciente);
        return new ResponseEntity<SintomaPaciente>(sintomaPaciente, HttpStatus.CREATED);
    }
}
