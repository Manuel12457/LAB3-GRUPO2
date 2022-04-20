package com.example.lab3grupo4.entity;

import javax.persistence.*;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopcion", nullable = false)
    private int id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "tiempo_minutos", nullable = false)
    private int tiempoMinutos;

    @Column(name = "precio", nullable = false)
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(int tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

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