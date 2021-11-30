package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "comorbidade_paciente")
@Entity(name = "Comorbidade_Paciente")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class ComorbidadePaciente implements Serializable {
    private static final long serialVersionUID = 7411419949574622214L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compacid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Setter private Paciente cpf;

    @ManyToOne(optional = false)
    @JoinColumn(name = "comid", nullable = false)
    @Setter private Comorbidade comorbidadeId;

    public ComorbidadePaciente(Paciente cpf, Comorbidade comorbidadeId) {
        this.cpf = cpf;
        this.comorbidadeId = comorbidadeId;
    }
}