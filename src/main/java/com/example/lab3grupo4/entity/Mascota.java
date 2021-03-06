package com.example.lab3grupo4.entity;

import com.example.lab3grupo4.entity.Cuenta;
import com.example.lab3grupo4.entity.RazaEspecie;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmascota", nullable = false)
    private int idmascota;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "anho", nullable = false)
    private String anho;

    @Lob
    @Column(name = "historia", nullable = false)
    private String historia;

    @Lob
    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "raza_especie_idraza", nullable = false)
    private RazaEspecie razaEspecieIdraza;

    @Column(name = "raza_otros")
    private String razaOtros;

    @ManyToOne
    @JoinColumn(name = "cuenta_idcuenta")
    private Cuenta cuentaIdcuenta;

    public Cuenta getCuentaIdcuenta() {
        return cuentaIdcuenta;
    }

    public void setCuentaIdcuenta(Cuenta cuentaIdcuenta) {
        this.cuentaIdcuenta = cuentaIdcuenta;
    }

    public String getRazaOtros() {
        return razaOtros;
    }

    public void setRazaOtros(String razaOtros) {
        this.razaOtros = razaOtros;
    }

    public RazaEspecie getRazaEspecieIdraza() {
        return razaEspecieIdraza;
    }

    public void setRazaEspecieIdraza(RazaEspecie razaEspecieIdraza) {
        this.razaEspecieIdraza = razaEspecieIdraza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int id) {
        this.idmascota = id;
    }
}