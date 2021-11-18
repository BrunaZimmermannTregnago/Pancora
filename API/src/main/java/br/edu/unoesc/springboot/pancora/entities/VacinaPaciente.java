package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "vacina_paciente")
@Entity(name = "Vacina_Paciente")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VacinaPaciente implements Serializable {
    private static final long serialVersionUID = 6869011545160176814L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacpacid", nullable = false)
    @Getter private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Getter @Setter private Paciente cpf;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vacid", nullable = false)
    @Getter @Setter private Vacina vacinaId;

    @Column(name = "vacdos", nullable = false, precision = 1)
    @Getter @Setter private BigDecimal dose;
}