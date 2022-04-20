package com.example.lab3grupo4.entity;

import javax.persistence.*;

@Entity
@Table(name = "responsable")
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresponsable", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}