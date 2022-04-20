package com.example.lab3grupo4.entity;

import javax.persistence.*;

@Entity
@Table(name = "raza_especie")
public class RazaEspecie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idraza", nullable = false)
    private int id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}