package com.example.plataformaEscolar.dominio;

import java.util.Date;

public class Inscripcion {

    private Date fechaInscripcion;
    private boolean estado;

    public Inscripcion() {
    }

    public Inscripcion(Date fechaInscripcion, boolean estado) {
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "fechaInscripcion=" + fechaInscripcion +
                ", estado=" + estado +
                '}';
    }
}
