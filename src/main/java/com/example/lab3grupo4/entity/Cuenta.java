package com.example.lab3grupo4.entity;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta", nullable = false)
    private int id;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "admin")
    private int admin;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}