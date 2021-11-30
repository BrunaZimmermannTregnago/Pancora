package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "vacina_paciente")
@Entity(name = "Vacina_Paciente")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class VacinaPaciente implements Serializable {
    private static final long serialVersionUID = 6869011545160176814L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacpacid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Setter private Paciente cpf;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vacid", nullable = false)
    @Setter private Vacina vacinaId;

    @Column(name = "vacdos", nullable = false, precision = 1)
    @Setter private BigDecimal dose;

    public VacinaPaciente(Paciente cpf, Vacina vacinaId, BigDecimal dose) {
        this.cpf = cpf;
        this.vacinaId = vacinaId;
        this.dose = dose;
    }
}