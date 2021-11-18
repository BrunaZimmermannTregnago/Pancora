package br.edu.unoesc.springboot.pancora.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "comorbidade", indexes = {
        @Index(name = "comorbidade_comdes_key", columnList = "comdes", unique = true)
})
@Entity(name = "Comorbidade")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comorbidade implements Serializable {
    private static final long serialVersionUID = -1848373027810511848L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comid", nullable = false)
    @Getter private Integer id;

    @Column(name = "comdes", nullable = false, length = 80)
    @Getter @Setter private String descricao;
}