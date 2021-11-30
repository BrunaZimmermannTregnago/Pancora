package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "paciente")
@Entity(name = "Paciente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString(of = {"nome", "sexo", "peso", "altura"})
public class Paciente implements Serializable {
    private static final long serialVersionUID = -1766813873933469728L;
    @Id
    @Column(name = "paccpf", nullable = false, precision = 11)
    private BigDecimal cpf;

    @Column(name = "pacsex", nullable = false, length = 1)
    @Setter private String sexo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipusuid", nullable = false)
    @Setter private TipoUsuario tipoUsuarioId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cidid", nullable = false)
    @Setter private Cidade cidadeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "baiid", nullable = false)
    @Setter private Bairro bairroId;

    @Column(name = "paccep", nullable = false)
    @Setter private Integer cep;

    @Column(name = "pacendnum", nullable = false, length = 15)
    @Setter private String numeroEndereco;

    @Column(name = "pacendrua", nullable = false, length = 250)
    @Setter private String ruaEndereco;

    @Column(name = "pacalt", nullable = false, precision = 3, scale = 2)
    @Setter private BigDecimal altura;

    @Column(name = "pacpes", nullable = false, precision = 5, scale = 2)
    @Setter private BigDecimal peso;

    @Column(name = "pacdatnas", nullable = false)
    @Setter private LocalDate dataNascimento;

    @Column(name = "pacema", nullable = false, length = 60)
    @Setter private String email;

    @Column(name = "pactel", nullable = false, length = 15)
    @Setter private String telefone;

    @Column(name = "pacnom", nullable = false, length = 200)
    @Setter private String nome;
}
