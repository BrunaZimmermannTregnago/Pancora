package br.edu.unoesc.springboot.pancora.dto;

import br.edu.unoesc.springboot.pancora.entities.SintomaPaciente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class SintomaPacienteDTO implements Serializable {
    private static final long serialVersionUID = 4315809461473902931L;

    private Integer id;

    @Setter private Integer sintomaId;

    @Setter private BigDecimal cpf;

    @Setter private LocalDate dataFinal;

    @Setter private String grauIntesidade;

    @Setter private LocalDate dataInicio;

    public SintomaPaciente getSintomaPaciente() {
        SintomaPaciente sintomaPaciente = new SintomaPaciente();

        sintomaPaciente.setDataFinal(this.dataFinal);
        sintomaPaciente.setGrauIntesidade(this.grauIntesidade);
        sintomaPaciente.setDataInicio(this.dataInicio);
        
        return sintomaPaciente;
    }
}