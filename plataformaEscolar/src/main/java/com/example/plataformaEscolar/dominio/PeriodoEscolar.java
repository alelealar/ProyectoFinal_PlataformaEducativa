package com.example.plataformaEscolar.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un periodo escolar dentro de la plataforma.
 * Contiene las fechas del periodo, las fechas de inscripción
 * y los alumnos relacionados con él.
 *
 * @author Equipo 2 - Amarillo
 */
public class PeriodoEscolar {

    /**
     * Fecha de inicio del periodo escolar.
     */
    private LocalDate fechaInicio;

    /**
     * Fecha de fin del periodo escolar.
     */
    private LocalDate fechaFin;

    /**
     * Fecha de inicio de las inscripciones.
     */
    private LocalDate fechaInicioInscripcion;

    /**
     * Fecha de fin de las inscripciones.
     */
    private LocalDate fechaFinInscripcion;

    /**
     * Nombre del periodo escolar.
     */
    private String nombrePeriodo;

    /**
     * Alumnos relacionados con el periodo escolar.
     */
    private List<Alumno> alumnos;

    /**
     * Crea un periodo escolar vacío.
     */
    public PeriodoEscolar() {
        this.alumnos = new ArrayList<>();
    }

    /**
     * Crea un periodo escolar con todos sus datos.
     *
     * @param fechaInicio fecha de inicio del periodo
     * @param fechaFin fecha de fin del periodo
     * @param fechaInicioInscripcion fecha de inicio de las inscripciones
     * @param fechaFinInscripcion fecha de fin de las inscripciones
     * @param nombrePeriodo nombre del periodo
     * @param alumnos alumnos relacionados con el periodo
     */
    public PeriodoEscolar(LocalDate fechaInicio, LocalDate fechaFin,
                          LocalDate fechaInicioInscripcion,
                          LocalDate fechaFinInscripcion,
                          String nombrePeriodo, List<Alumno> alumnos) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.nombrePeriodo = nombrePeriodo;
        this.alumnos = alumnos;
    }

    /**
     * Regresa la fecha de inicio del periodo.
     *
     * @return fecha de inicio
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Cambia la fecha de inicio del periodo.
     *
     * @param fechaInicio nueva fecha de inicio
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Regresa la fecha de fin del periodo.
     *
     * @return fecha de fin
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Cambia la fecha de fin del periodo.
     *
     * @param fechaFin nueva fecha de fin
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Regresa la fecha de inicio de las inscripciones.
     *
     * @return fecha de inicio de inscripción
     */
    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    /**
     * Cambia la fecha de inicio de las inscripciones.
     *
     * @param fechaInicioInscripcion nueva fecha de inicio de inscripción
     */
    public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
        this.fechaInicioInscripcion = fechaInicioInscripcion;
    }

    /**
     * Regresa la fecha de fin de las inscripciones.
     *
     * @return fecha de fin de inscripción
     */
    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    /**
     * Cambia la fecha de fin de las inscripciones.
     *
     * @param fechaFinInscripcion nueva fecha de fin de inscripción
     */
    public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    /**
     * Regresa el nombre del periodo.
     *
     * @return nombre del periodo
     */
    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    /**
     * Cambia el nombre del periodo.
     *
     * @param nombrePeriodo nuevo nombre del periodo
     */
    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    /**
     * Regresa los alumnos del periodo.
     *
     * @return lista de alumnos
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Cambia los alumnos del periodo.
     *
     * @param alumnos nueva lista de alumnos
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Regresa la información del periodo escolar.
     *
     * @return datos del periodo en texto
     */
    @Override
    public String toString() {
        return "PeriodoEscolar{" +
                "nombrePeriodo='" + nombrePeriodo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaInicioInscripcion=" + fechaInicioInscripcion +
                ", fechaFinInscripcion=" + fechaFinInscripcion +
                '}';
    }
}