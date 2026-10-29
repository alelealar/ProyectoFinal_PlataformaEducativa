package com.example.plataformaEscolar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un periodo escolar lectivo dentro de la plataforma.
 * Contiene las fechas del periodo, las ventanas de inscripción
 * y las clases o grupos aperturados para dicho periodo.
 *
 * @author Equipo 2 - Amarillo
 */
public class PeriodoEscolar {

    /**
     * Identificador único del periodo escolar.
     */
    private Long id; // Cambiado de int a Long

    /**
     * Nombre descriptivo del periodo escolar (ej. "Enero - Mayo 2026").
     */
    private String nombrePeriodo;

    /**
     * Fecha de inicio del periodo lectivo.
     */
    private LocalDate fechaInicio;

    /**
     * Fecha de fin del periodo lectivo.
     */
    private LocalDate fechaFin;

    /**
     * Fecha de inicio del proceso de inscripciones y carga académica.
     */
    private LocalDate fechaInicioInscripcion;

    /**
     * Fecha límite para el proceso de inscripciones.
     */
    private LocalDate fechaFinInscripcion;

    /**
     * Lista de clases o grupos ofertados durante este periodo escolar.
     */
    private List<Clase> clases;

    /**
     * Crea un periodo escolar vacío e inicializa sus colecciones.
     */
    public PeriodoEscolar() {
        this.clases = new ArrayList<>();
    }

    /**
     * Crea un periodo escolar con sus datos principales.
     *
     * @param id identificador del periodo (Long)
     * @param nombrePeriodo nombre del periodo
     * @param fechaInicio fecha de inicio lectivo
     * @param fechaFin fecha de fin lectivo
     * @param fechaInicioInscripcion apertura de inscripciones
     * @param fechaFinInscripcion cierre de inscripciones
     */
    public PeriodoEscolar(Long id, String nombrePeriodo, LocalDate fechaInicio, LocalDate fechaFin,
                          LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        this.id = id;
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.clases = new ArrayList<>();
    }

    /**
     * Crea un periodo escolar con todos sus datos completos, incluyendo su oferta de clases.
     *
     * @param id identificador del periodo (Long)
     * @param nombrePeriodo nombre del periodo
     * @param fechaInicio fecha de inicio lectivo
     * @param fechaFin fecha de fin lectivo
     * @param fechaInicioInscripcion apertura de inscripciones
     * @param fechaFinInscripcion cierre de inscripciones
     * @param clases lista de clases aperturadas
     */
    public PeriodoEscolar(Long id, String nombrePeriodo, LocalDate fechaInicio, LocalDate fechaFin,
                          LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion,
                          List<Clase> clases) {
        this.id = id;
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.clases = (clases != null) ? clases : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
        this.fechaInicioInscripcion = fechaInicioInscripcion;
    }

    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = (clases != null) ? clases : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PeriodoEscolar{" +
                "id=" + id +
                ", nombrePeriodo='" + nombrePeriodo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaInicioInscripcion=" + fechaInicioInscripcion +
                ", fechaFinInscripcion=" + fechaFinInscripcion +
                '}';
    }
}