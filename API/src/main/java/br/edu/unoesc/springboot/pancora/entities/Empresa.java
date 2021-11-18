package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "empresa")
@Entity(name = "Empresa")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empresa implements Serializable {
    private static final long serialVersionUID = 7595634282930721716L;
    @Id
    @Column(name = "empcnpj", nullable = false, precision = 14)
    @Getter private BigDecimal cnpj;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cidid", nullable = false)
    @Getter @Setter private Cidade cidadeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "baiid", nullable = false)
    @Getter @Setter private Bairro bairroId;

    @Column(name = "empcep", nullable = false)
    @Getter @Setter Integer cep;

    @Column(name = "empendnum", nullable = false, length = 15)
    @Getter @Setter private String numeroEndereco;

    @Column(name = "empendrua", nullable = false)
    @Getter @Setter private String ruaEndereco;

    @Column(name = "empramati", length = 80)
    @Getter @Setter private String ramoAtividade;

    @Column(name = "empema", length = 60)
    @Getter @Setter private String email;

    @Column(name = "emptel", nullable = false, length = 15)
    @Getter @Setter private String telefone;

    @Column(name = "empnomfan", nullable = false, length = 80)
    @Getter @Setter private String nomeFantasia;

    @Column(name = "emprazsoc", nullable = false, length = 80)
    @Getter @Setter private String razaoSocial;
}