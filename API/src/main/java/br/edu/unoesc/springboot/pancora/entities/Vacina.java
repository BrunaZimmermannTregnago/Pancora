package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "vacina")
@Entity(name = "Vacina")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Vacina implements Serializable {
    private static final long serialVersionUID = -5039339405712388047L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacid", nullable = false)
    private Integer id;

    @Column(name = "vacnom", nullable = false, length = 100)
    @Setter private String nome;

    public Vacina(String nome) {
        this.nome = nome;
    }
}