package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "situacao", indexes = {
        @Index(name = "situacao_sitpac_key", columnList = "sitpac", unique = true)
})
@Entity(name = "Situacao")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Situacao implements Serializable {
    private static final long serialVersionUID = 8530730043136723737L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitid", nullable = false)
    private Integer id;

    @Column(name = "sitpac", nullable = false, length = 20)
    @Setter private String situacao;

    public Situacao(String situacao) {
        this.situacao = situacao;
    }
}