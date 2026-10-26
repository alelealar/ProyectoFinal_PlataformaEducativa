package com.example.plataformaEscolar.model;

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
    private Long id; // Cambiado de int a Long

    /**
     * Fecha y hora exacta en la que se confirmó la inscripción.
     */
    private LocalDateTime fechaInscripcion;

    /**
     * Calificación final obtenida por el alumno en la materia inscrita.
     */
    private float calificacion;

    /**
     * Estado actual de la inscripción mediante enumeración.
     */
    private EstadoInscripcion estado;

    /**
     * Alumno que realiza la inscripción.
     */
    private Alumno alumno;

    /**
     * Clase o grupo al cual se inscribe el alumno.
     */
    private Clase clase;

    /**
     * Crea una inscripción vacía con estado por defecto en INSCRITA.
     */
    public Inscripcion() {
        this.estado = EstadoInscripcion.INSCRITA;
    }

    /**
     * Crea una inscripción con los datos básicos.
     *
     * @param id identificador de la inscripción (Long)
     * @param fechaInscripcion fecha y hora de la transacción
     * @param estado estado de la inscripción
     * @param alumno alumno involucrado
     * @param clase clase seleccionada
     */
    public Inscripcion(Long id, LocalDateTime fechaInscripcion, EstadoInscripcion estado, Alumno alumno, Clase clase) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.calificacion = 0.0f;
        this.estado = estado;
        this.alumno = alumno;
        this.clase = clase;
    }

    /**
     * Crea una inscripción completa incluyendo la calificación final.
     *
     * @param id identificador de la inscripción (Long)
     * @param fechaInscripcion fecha y hora de la transacción
     * @param calificacion calificación otorgada
     * @param estado estado de la inscripción
     * @param alumno alumno involucrado
     * @param clase clase seleccionada
     */
    public Inscripcion(Long id, LocalDateTime fechaInscripcion, float calificacion, EstadoInscripcion estado, Alumno alumno, Clase clase) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.calificacion = calificacion;
        this.estado = estado;
        this.alumno = alumno;
        this.clase = clase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", fechaInscripcion=" + fechaInscripcion +
                ", calificacion=" + calificacion +
                ", estado=" + estado +
                ", alumno=" + (alumno != null ? alumno.getMatricula() : "null") +
                ", clase=" + (clase != null ? clase.getClave() : "null") +
                '}';
    }
}