package com.example.plataformaEscolar.model;

public class Carrera {

    private Long id; // Cambiado de int a Long
    private String clave;
    private String nombre;

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