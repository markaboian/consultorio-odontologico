package com.example.ClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilios_sequence", sequenceName = "domicilios_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilios_sequence")
    private long id;
    private String calle;
    private int numero;
    private String localidad;
    private int codigoPostal;

    @OneToMany(mappedBy = "domicilio")
    @JsonIgnore
    private Set<Paciente> pacientes;

    public Domicilio() {
    }

//    public Domicilio(String direccion, int numero, String localidad, int codigoPostal) {
//        this.direccion = direccion;
//        this.numero = numero;
//        this.localidad = localidad;
//        this.codigoPostal = codigoPostal;
//    }
//
//    public Domicilio(long id, String direccion, int numero, String localidad, int codigoPostal) {
//        this.id = id;
//        this.direccion = direccion;
//        this.numero = numero;
//        this.localidad = localidad;
//        this.codigoPostal = codigoPostal;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", localidad='" + localidad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", pacientes=" + pacientes +
                '}';
    }
}
