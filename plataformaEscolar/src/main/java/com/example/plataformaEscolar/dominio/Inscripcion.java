package com.example.plataformaEscolar.dominio;

import java.time.LocalDateTime;

/**
 * Representa el registro de alta de una clase para un alumno en un periodo determinado.
 * Funciona como entidad relacional intermedia entre Alumno y Clase.
 *
 * @author Equipo 2 - Amarillo
 */
public class Inscripcion {

    /**
     * Identificador único de la inscripción.
     */
    private int id;

    /**
     * Fecha y hora exacta en la que se confirmó la inscripción.
     */
    private LocalDateTime fechaInscripcion;

    /**
     * Estatus actual de la inscripción (ej. "CONFIRMADA", "CANCELADA").
     */
    private String estatus;

    /**
     * Alumno que realiza la inscripción.
     */
    private Alumno alumno;

    /**
     * Clase o grupo al cual se inscribe el alumno.
     */
    private Clase clase;

    /**
     * Crea una inscripción vacía.
     */
    public Inscripcion() {
    }

    /**
     * Crea una inscripción completa.
     *
     * @param id identificador de la inscripción
     * @param fechaInscripcion fecha y hora de la transacción
     * @param estatus estado de la inscripción
     * @param alumno alumno involucrado
     * @param clase clase seleccionada
     */
    public Inscripcion(int id, LocalDateTime fechaInscripcion, String estatus, Alumno alumno, Clase clase) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.estatus = estatus;
        this.alumno = alumno;
        this.clase = clase;
    }

    /**
     * Regresa el identificador de la inscripción.
     *
     * @return id de la inscripción
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador de la inscripción.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa la fecha y hora de la inscripción.
     *
     * @return fecha y hora
     */
    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Cambia la fecha y hora de la inscripción.
     *
     * @param fechaInscripcion nueva fecha y hora
     */
    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Regresa el estatus de la inscripción.
     *
     * @return estatus actual
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Cambia el estatus de la inscripción.
     *
     * @param estatus nuevo estatus
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * Regresa el alumno asociado a la inscripción.
     *
     * @return alumno inscrito
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Cambia el alumno asociado a la inscripción.
     *
     * @param alumno nuevo alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Regresa la clase asociada a la inscripción.
     *
     * @return clase inscrita
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Cambia la clase asociada a la inscripción.
     *
     * @param clase nueva clase
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }

    /**
     * Regresa la información de la inscripción en texto.
     *
     * @return representación en cadena de la inscripción
     */
    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", fechaInscripcion=" + fechaInscripcion +
                ", estatus='" + estatus + '\'' +
                ", alumno=" + (alumno != null ? alumno.getMatricula() : "null") +
                ", clase=" + (clase != null ? clase.getClave() : "null") +
                '}';
    }
}