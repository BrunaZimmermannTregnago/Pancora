package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "sintoma_paciente")
@Entity(name = "Sintoma_Paciente")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SintomaPaciente implements Serializable {
    private static final long serialVersionUID = 4315809461473902931L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sintipid", nullable = false)
    @Getter private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sinid", nullable = false)
    @Getter @Setter private Sintoma sintomaId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Getter @Setter private Paciente cpf;

    @Column(name = "sinpacdatfim")
    @Getter @Setter private LocalDate dataFinal;

    @Column(name = "sinpacgraint", nullable = false, length = 50)
    @Getter @Setter private String grauIntesidade;

    @Column(name = "sinpacdatini", nullable = false)
    @Getter @Setter private LocalDate dataInicio;
}