package com.example.lab3grupo4.entity;

import javax.persistence.*;

@Entity
@Table(name = "raza_especie")
public class RazaEspecie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idraza", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}