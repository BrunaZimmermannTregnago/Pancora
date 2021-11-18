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
@ToString
public class Paciente implements Serializable {
    private static final long serialVersionUID = -1766813873933469728L;
    @Id
    @Column(name = "paccpf", nullable = false, precision = 11)
    @Getter private BigDecimal cpf;

    @Column(name = "pacsex", nullable = false, length = 1)
    @Getter @Setter private String sexo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipusuid", nullable = false)
    @Getter @Setter private TipoUsuario tipoUsuarioId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cidid", nullable = false)
    @Getter @Setter private Cidade cidadeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "baiid", nullable = false)
    @Getter @Setter private Bairro bairroId;

    @Column(name = "paccep", nullable = false)
    @Getter @Setter private Integer cep;

    @Column(name = "pacendnum", nullable = false, length = 15)
    @Getter @Setter private String numeroEndereco;

    @Column(name = "pacendrua", nullable = false, length = 250)
    @Getter @Setter private String ruaEndereco;

    @Column(name = "pacalt", nullable = false, precision = 3, scale = 2)
    @Getter @Setter private BigDecimal altura;

    @Column(name = "pacpes", nullable = false, precision = 5, scale = 2)
    @Getter @Setter private BigDecimal peso;

    @Column(name = "pacdatnas", nullable = false)
    @Getter @Setter private LocalDate dataNascimento;

    @Column(name = "pacema", nullable = false, length = 60)
    @Getter @Setter private String email;

    @Column(name = "pactel", nullable = false, length = 15)
    @Getter @Setter private String telefone;

    @Column(name = "pacnom", nullable = false, length = 200)
    @Getter @Setter private String nome;
}
