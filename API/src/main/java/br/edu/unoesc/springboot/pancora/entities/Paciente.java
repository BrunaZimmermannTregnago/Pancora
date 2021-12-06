package br.edu.unoesc.springboot.pancora.entities;

import br.edu.unoesc.springboot.pancora.appuser.AppUser;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "paciente")
@Entity(name = "Paciente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString(of = {"nome", "sexo", "peso", "altura"})
public class Paciente implements Serializable {
    private static final long serialVersionUID = -1766813873933469728L;
    @Id
    @Column(name = "paccpf", nullable = false, precision = 11)
    private BigDecimal cpf;

    @OneToOne
    @JoinColumn(name = "usuario", nullable = false)
    private AppUser usuario;

    @Column(name = "pacsex", nullable = false, length = 1)
    private String sexo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cidid", nullable = false)
    private Cidade cidadeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "baiid", nullable = false)
    private Bairro bairroId;

    @Column(name = "paccep", nullable = false)
    private Integer cep;

    @Column(name = "pacendnum", nullable = false, length = 15)
    private String numeroEndereco;

    @Column(name = "pacendrua", nullable = false, length = 250)
    private String ruaEndereco;

    @Column(name = "pacalt", nullable = false, precision = 3, scale = 2)
    private BigDecimal altura;

    @Column(name = "pacpes", nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "pacdatnas", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "pactel", nullable = false, length = 15)
    private String telefone;

    @Column(name = "pacnom", nullable = false, length = 200)
    private String nome;

//    @OneToMany(mappedBy = "cpf", fetch = FetchType.EAGER)
//    @Getter
//    List<SintomaPaciente> sintomaPacienteList;

//    @OneToMany(mappedBy = "cpf", fetch = FetchType.EAGER)
//    @Getter
//    List<SituacaoPaciente> situacaoPacienteList;
}
