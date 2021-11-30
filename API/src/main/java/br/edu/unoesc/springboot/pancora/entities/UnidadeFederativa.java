package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "unidade_federativa", indexes = {
        @Index(name = "unidade_federativa_ufsignom_key", columnList = "ufsignom", unique = true)
})
@Entity(name = "Unidade_Federativa")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class UnidadeFederativa implements Serializable {
    private static final long serialVersionUID = 190039050334954986L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ufid", nullable = false)
    private Integer id;

    @Column(name = "ufsignom", nullable = false, length = 2)
    @Setter private String nomeSigla;

    public UnidadeFederativa(String nomeSigla) {
        this.nomeSigla = nomeSigla;
    }
}