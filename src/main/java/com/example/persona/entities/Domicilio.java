package com.example.persona.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private int numero;

    @ManyToOne(optional = false) //indicamos que la relacion no puede ser nula
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

}
