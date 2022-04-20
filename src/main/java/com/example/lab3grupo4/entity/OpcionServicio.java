package com.example.lab3grupo4.entity;

import com.example.lab3grupo4.entity.Opcion;
import com.example.lab3grupo4.entity.Servicio;

import javax.persistence.*;

@Entity
@Table(name = "opcion_servicio")
public class OpcionServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopcion_servicio", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "opcion_idopcion", nullable = false)
    private Opcion opcionIdopcion;

    @ManyToOne
    @JoinColumn(name = "servicio_idservicio", nullable = false)
    private Servicio servicioIdservicio;

    public Servicio getServicioIdservicio() {
        return servicioIdservicio;
    }

    public void setServicioIdservicio(Servicio servicioIdservicio) {
        this.servicioIdservicio = servicioIdservicio;
    }

    public Opcion getOpcionIdopcion() {
        return opcionIdopcion;
    }

    public void setOpcionIdopcion(Opcion opcionIdopcion) {
        this.opcionIdopcion = opcionIdopcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}