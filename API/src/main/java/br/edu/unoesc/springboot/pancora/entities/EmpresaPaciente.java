package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "empresa_paciente")
@Entity(name = "Empresa_Paciente")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class EmpresaPaciente implements Serializable {
    private static final long serialVersionUID = 585617458094246317L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emppacid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paccpf", nullable = false)
    @Setter private Paciente cpf;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empcnpj", nullable = false)
    @Setter private Empresa cnpj;

    @Column(name = "emppacfun", nullable = false, length = 80)
    @Setter private String funcaoPaciente;

    public EmpresaPaciente(Paciente cpf, Empresa cnpj, String funcaoPaciente) {
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.funcaoPaciente = funcaoPaciente;
    }
}