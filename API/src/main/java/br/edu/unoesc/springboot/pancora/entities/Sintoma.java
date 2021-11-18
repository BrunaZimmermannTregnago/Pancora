package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sintoma", indexes = {
        @Index(name = "sintoma_sindes_key", columnList = "sindes", unique = true)
})
@Entity(name = "Sintoma")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sintoma implements Serializable {
    private static final long serialVersionUID = 2207964645489628432L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sinid", nullable = false)
    @Getter private Integer id;

    @Column(name = "sindes", nullable = false, length = 80)
    @Getter @Setter private String descricao;
}