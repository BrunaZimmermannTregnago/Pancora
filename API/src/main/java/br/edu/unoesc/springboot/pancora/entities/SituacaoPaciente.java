package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "situacao_paciente")
@Entity(name = "Situacao_Paciente")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class SituacaoPaciente implements Serializable {
    private static final long serialVersionUID = 65672102956723559L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitpacid", nullable = false)
    private Integer id;

    @Column(name = "sitpacdatfim")
    @Setter private LocalDate dataFinal;

    @Column(name = "sitpacdatini", nullable = false)
    @Setter private LocalDate dataInicio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Setter private Paciente cpf;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sitid", nullable = false)
    @Setter private Situacao situacaoId;

    public SituacaoPaciente(LocalDate dataFinal, LocalDate dataInicio, Paciente cpf, Situacao situacaoId) {
        this.dataFinal = dataFinal;
        this.dataInicio = dataInicio;
        this.cpf = cpf;
        this.situacaoId = situacaoId;
    }
}