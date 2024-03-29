package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "orientacao")
@Entity(name = "Orientacao")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Orientacao implements Serializable {
    private static final long serialVersionUID = -844035544792689189L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oricid", nullable = false)
    private Integer id;

    @Column(name = "orides", nullable = false)
    @Setter private String descricao;

    public Orientacao(String descricao) {
        this.descricao = descricao;
    }
}