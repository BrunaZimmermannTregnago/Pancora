package br.edu.unoesc.springboot.pancora.dto;

import br.edu.unoesc.springboot.pancora.entities.Paciente;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe DTO para a classe Paciente
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PacienteDTO implements Serializable {
    private static final long serialVersionUID = -1766813873933469728L;

    private BigDecimal cpf;

    private String sexo;

    private Long usuario;

    private Integer cidadeId;

    private Integer bairroId;

    private Integer cep;

    private String numeroEndereco;

    private String ruaEndereco;

    private BigDecimal altura;

    private BigDecimal peso;

    private LocalDate dataNascimento;

    private String telefone;

    private String nome;

    /**
     * Método getPaciente para criação de um novo paciente, cujos atributos não setados devem ser complementados posteriormente
     * @return novo objeto paciente
     */
    public Paciente getPaciente() {
        Paciente paciente = new Paciente();

        paciente.setCpf(this.cpf);
        paciente.setNome(this.nome);
        paciente.setTelefone(this.telefone);
        paciente.setDataNascimento(this.dataNascimento);
        paciente.setPeso(this.peso);
        paciente.setAltura(this.altura);
        paciente.setRuaEndereco(this.ruaEndereco);
        paciente.setNumeroEndereco(this.numeroEndereco);
        paciente.setCep(this.cep);
        paciente.setSexo(this.sexo);

        return paciente;
    }
}
