package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "situacao_paciente")
@Entity(name = "Situacao_Paciente")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SituacaoPaciente implements Serializable {
    private static final long serialVersionUID = 65672102956723559L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitpacid", nullable = false)
    @Getter private Integer id;

    @Column(name = "sitpacdatfim")
    @Getter @Setter private LocalDate dataFinal;

    @Column(name = "sitpacdatini", nullable = false)
    @Getter @Setter private LocalDate dataInicio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Getter @Setter private Paciente cpf;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sitid", nullable = false)
    @Getter @Setter private Situacao situacaoId;
}