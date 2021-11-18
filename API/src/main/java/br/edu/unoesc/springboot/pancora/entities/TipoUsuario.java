package br.edu.unoesc.springboot.pancora.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tipo_usuario")
@Entity(name = "Tipo_Usuario")
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 3921987980209989972L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipusuid", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}