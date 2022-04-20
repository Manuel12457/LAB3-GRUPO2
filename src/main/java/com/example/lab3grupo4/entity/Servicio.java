package com.example.lab3grupo4.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio", nullable = false)
    private Integer idservicio;

    @ManyToOne
    @JoinColumn(name = "mascota_idmascota", nullable = false)
    private Mascota mascotaIdmascota;

    @ManyToOne
    @JoinColumn(name = "cuenta_idcuenta", nullable = false)
    private Cuenta cuentaIdcuenta;

    @Column(name = "hora_inicio", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm")
    private LocalDateTime horaInicio;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Lob
    @Column(name = "entrega", nullable = false)
    private String entrega;

    @ManyToOne
    @JoinColumn(name = "responsable_idresponsable", nullable = false)
    private Responsable responsableIdresponsable;

    public Responsable getResponsableIdresponsable() {
        return responsableIdresponsable;
    }

    public void setResponsableIdresponsable(Responsable responsableIdresponsable) {
        this.responsableIdresponsable = responsableIdresponsable;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Cuenta getCuentaIdcuenta() {
        return cuentaIdcuenta;
    }

    public void setCuentaIdcuenta(Cuenta cuentaIdcuenta) {
        this.cuentaIdcuenta = cuentaIdcuenta;
    }

    public Mascota getMascotaIdmascota() {
        return mascotaIdmascota;
    }

    public void setMascotaIdmascota(Mascota mascotaIdmascota) {
        this.mascotaIdmascota = mascotaIdmascota;
    }

    public int getId() {
        return idservicio;
    }

    public void setId(Integer id) {
        this.idservicio = id;
    }
}