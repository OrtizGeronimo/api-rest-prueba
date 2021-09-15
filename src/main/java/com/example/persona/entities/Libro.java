package com.example.persona.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Libro extends Base{


    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private int fecha;
    @Column(name = "genero")
    private String genero;
    @Column(name = "paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH) //al momento de persistir un libro, siempre se actualizan los autores
    private List<Autor> autores = new ArrayList<Autor>();

}
