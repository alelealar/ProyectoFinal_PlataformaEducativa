package com.example.plataformaEscolar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado de int a Long

    @Min(value = 1)
    @Max(value = 100)
    private String clave;

    @NotBlank(message = "El nombre de la carrera no puede estar en blanco")
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "plan_estudio")
    private List<PlanEstudio> planEstudios;

    public Carrera() {
    }

    public Carrera(Long id, String clave, String nombre) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}