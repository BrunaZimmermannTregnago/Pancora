package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "sintoma_paciente")
@Entity(name = "Sintoma_Paciente")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class SintomaPaciente implements Serializable {
    private static final long serialVersionUID = 4315809461473902931L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sintipid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sinid", nullable = false)
    @Setter private Sintoma sintomaId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Setter private Paciente cpf;

    @Column(name = "sinpacdatfim")
    @Setter private LocalDate dataFinal;

    @Column(name = "sinpacgraint", nullable = false, length = 50)
    @Setter private String grauIntesidade;

    @Column(name = "sinpacdatini", nullable = false)
    @Setter private LocalDate dataInicio;

    public SintomaPaciente(Sintoma sintomaId, Paciente cpf, LocalDate dataFinal, String grauIntesidade, LocalDate dataInicio) {
        this.sintomaId = sintomaId;
        this.cpf = cpf;
        this.dataFinal = dataFinal;
        this.grauIntesidade = grauIntesidade;
        this.dataInicio = dataInicio;
    }
}