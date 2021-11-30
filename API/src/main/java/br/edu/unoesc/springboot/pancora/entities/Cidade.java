package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "cidade")
@Entity(name = "Cidade")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Cidade implements Serializable {
    private static final long serialVersionUID = -1691880446913202999L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ufid", nullable = false)
    @Setter private UnidadeFederativa ufId;

    @Column(name = "cidnom", nullable = false, length = 250)
    @Setter private String nome;

    public Cidade(UnidadeFederativa ufId, String nome) {
        this.ufId = ufId;
        this.nome = nome;
    }
}