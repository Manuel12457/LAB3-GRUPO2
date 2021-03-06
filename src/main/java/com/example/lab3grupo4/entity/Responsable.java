package com.example.lab3grupo4.entity;

import javax.persistence.*;

@Entity
@Table(name = "responsable")
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresponsable", nullable = false)
    private int idresponsable;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int id) {
        this.idresponsable = id;
    }
}