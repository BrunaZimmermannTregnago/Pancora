package br.edu.unoesc.springboot.pancora.controllers;

import br.edu.unoesc.springboot.pancora.appuser.AppUser;
import br.edu.unoesc.springboot.pancora.appuser.AppUserRepository;
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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller para requisições de cadastro, exceto cadastro de usuário
 */
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
    @Autowired
    private AppUserRepository appUserRepository;

    /**
     * Mapeia e {@return página de cadastro de paciente}
     */
    @GetMapping("/cadastro-paciente")
    public String cadastroPaciente() {
        return "cadastro-paciente";
    }

    /**
     * Mapeia a página de cadastro de paciente e realiza um novo cadastro
     * @param pacienteDTO DTO da classe Paciente
     * @param appUser objeto da classe AppUser, utilizado para conectar o usuario logado ao novo paciente
     * @return mensagem se o cadastro foi bem sucedido ou não
     */
    @PostMapping("/cadastro-paciente")
    @ResponseBody
    public ResponseEntity<Paciente> cadastraPaciente(@RequestBody PacienteDTO pacienteDTO, @AuthenticationPrincipal AppUser appUser) {
        Paciente paciente = pacienteDTO.getPaciente();
        paciente.setBairroId(bairroRepository.findById(pacienteDTO.getBairroId()).get());
        paciente.setCidadeId(cidadeRepository.findById(pacienteDTO.getCidadeId()).get());
        paciente.setUsuario(appUserRepository.findById(appUser.getId()).get());

        pacienteRepository.save(paciente);
        return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
    }

    /**
     * Mapeia e {@return página de cadastro de empresa}
     */
    @GetMapping("/cadastro-empresa")
    public String cadastroEmpresa() {
        return "cadastro-empresa";
    }

    /**
     * Mapeia a página de cadastro de empresa e realiza um novo cadastro
     * @param empresaDTO DTO da classe Empresa
     * @return mensagem se o cadastro foi bem sucedido ou não
     */
    @PostMapping("/cadastro-empresa")
    @ResponseBody
    public ResponseEntity<Empresa> cadastraEmpresa(@RequestBody EmpresaDTO empresaDTO){
        Empresa empresa = empresaDTO.getEmpresa();
        empresa.setBairroId(bairroRepository.findById(empresaDTO.getBairroId()).get());
        empresa.setCidadeId(cidadeRepository.findById(empresaDTO.getCidadeId()).get());

        empresaRepository.save(empresa);
        return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
    }

    /**
     * Mapeia e {@return página de cadastro de sintomas do paciente}
     */
    @GetMapping("cadastro-sintoma")
    public String cadastroSintoma() {
        return "cadastro-sintoma";
    }

    /**
     * Mapeia a página de cadastro de sintomas do paciente e realiza um novo cadastro
     * @param sintomaPacienteDTO DTO da classe SintomaPaciente
     * @return mensagem se o cadastro foi bem sucedido ou não
     */
    @PostMapping("/cadastro-sintoma")
    @ResponseBody
    public ResponseEntity<SintomaPaciente> cadastraSintomaPaciente(@RequestBody SintomaPacienteDTO sintomaPacienteDTO, @AuthenticationPrincipal AppUser appUser){
        SintomaPaciente sintomaPaciente = sintomaPacienteDTO.getSintomaPaciente();
        sintomaPaciente.setCpf(pacienteRepository.findById(sintomaPacienteDTO.getCpf()).get());
//        sintomaPaciente.setCpf(pacienteRepository.getPacienteByAppUser(appUserRepository.getById(appUser.getId())));
        sintomaPaciente.setSintomaId(sintomaRepository.findById(sintomaPacienteDTO.getSintomaId()).get());

        sintomaPacienteRepository.save(sintomaPaciente);
        return new ResponseEntity<SintomaPaciente>(sintomaPaciente, HttpStatus.CREATED);
    }
}
