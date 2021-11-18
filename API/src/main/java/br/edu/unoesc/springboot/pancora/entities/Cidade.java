package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "cidade")
@Entity(name = "Cidade")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cidade implements Serializable {
    private static final long serialVersionUID = -1691880446913202999L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidid", nullable = false)
    @Getter private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ufid", nullable = false)
    @Getter @Setter private UnidadeFederativa ufId;

    @Column(name = "cidnom", nullable = false, length = 250)
    @Getter @Setter private String nome;
}