package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "bairro")
@Entity(name = "Bairro")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Bairro implements Serializable {
    private static final long serialVersionUID = -7468949067666584343L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baiid", nullable = false)
    private Integer id;

    @Column(name = "bainom", nullable = false, length = 250)
    @Setter private String nome;

    public Bairro(String nome) {
        this.nome = nome;
    }
}