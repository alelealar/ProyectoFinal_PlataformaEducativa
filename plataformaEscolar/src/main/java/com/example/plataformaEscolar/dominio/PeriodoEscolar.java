package com.example.plataformaEscolar.dominio;

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
    private int id;

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
     * Crea un periodo escolar vacío.
     */
    public PeriodoEscolar() {
        this.clases = new ArrayList<>();
    }

    /**
     * Crea un periodo escolar con sus datos principales.
     *
     * @param id identificador del periodo
     * @param nombrePeriodo nombre del periodo
     * @param fechaInicio fecha de inicio lectivo
     * @param fechaFin fecha de fin lectivo
     * @param fechaInicioInscripcion apertura de inscripciones
     * @param fechaFinInscripcion cierre de inscripciones
     */
    public PeriodoEscolar(int id, String nombrePeriodo, LocalDate fechaInicio, LocalDate fechaFin,
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
     * @param id identificador del periodo
     * @param nombrePeriodo nombre del periodo
     * @param fechaInicio fecha de inicio lectivo
     * @param fechaFin fecha de fin lectivo
     * @param fechaInicioInscripcion apertura de inscripciones
     * @param fechaFinInscripcion cierre de inscripciones
     * @param clases lista de clases aperturadas
     */
    public PeriodoEscolar(int id, String nombrePeriodo, LocalDate fechaInicio, LocalDate fechaFin,
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

    /**
     * Regresa el identificador del periodo escolar.
     *
     * @return id del periodo
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador del periodo escolar.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
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
     * Regresa las clases ofertadas en este periodo escolar.
     *
     * @return lista de clases
     */
    public List<Clase> getClases() {
        return clases;
    }

    /**
     * Cambia las clases ofertadas en este periodo escolar.
     *
     * @param clases nueva lista de clases
     */
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    /**
     * Regresa la información del periodo escolar en formato texto.
     *
     * @return datos del periodo en texto
     */
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