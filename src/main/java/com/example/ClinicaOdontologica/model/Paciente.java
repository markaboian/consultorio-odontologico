package com.example.ClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;

    private int dni;
    private String fechaDeAlta;
    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Turno> turnos;

    public Paciente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(String fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio=" + domicilio +
                ", dni=" + dni +
                ", fechaDeAlta='" + fechaDeAlta + '\'' +
                ", turnos=" + turnos +
                '}';
    }
}
