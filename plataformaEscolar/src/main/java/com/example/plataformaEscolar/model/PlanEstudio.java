package com.example.plataformaEscolar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa la estructura de un plan de estudios académico asociado a una carrera.
 * Administra las materias asignadas mediante la entidad intermedia PlanMateria.
 *
 * @author Equipo 2 - Amarillo
 */
public class PlanEstudio {

    /**
     * Identificador único del plan de estudios.
     */
    private Long id;

    /**
     * Clave oficial del plan de estudios (ej. "ISW-2020").
     */
    private String clave;

    /**
     * Fecha oficial en la que fue aprobado el plan de estudios.
     */
    private LocalDate fechaAprobacion;

    /**
     * Indica si el plan de estudios está activo para nuevas inscripciones.
     */
    private boolean activo;

    /**
     * Carrera universitaria a la que pertenece este plan de estudios.
     */
    private Carrera carrera;

    /**
     * Lista de materias asignadas a este plan a través de la relación intermedia PlanMateria.
     */
    private List<PlanMateria> planMaterias;

    /**
     * Constructor vacío. Inicializa las colecciones para evitar NullPointerException.
     */
    public PlanEstudio() {
        this.planMaterias = new ArrayList<>();
    }

    /**
     * Constructor con los datos principales del plan de estudios.
     *
     * @param id identificador único (Long)
     * @param clave clave del plan
     * @param fechaAprobacion fecha de aprobación
     * @param activo estatus activo/inactivo
     * @param carrera carrera asociada
     */
    public PlanEstudio(Long id, String clave, LocalDate fechaAprobacion, boolean activo, Carrera carrera) {
        this.id = id;
        this.clave = clave;
        this.fechaAprobacion = fechaAprobacion;
        this.activo = activo;
        this.carrera = carrera;
        this.planMaterias = new ArrayList<>();
    }

    /**
     * Constructor completo con lista de materias del plan.
     *
     * @param id identificador único (Long)
     * @param clave clave del plan
     * @param fechaAprobacion fecha de aprobación
     * @param activo estatus activo/inactivo
     * @param carrera carrera asociada
     * @param planMaterias lista de materias configuradas en el plan
     */
    public PlanEstudio(Long id, String clave, LocalDate fechaAprobacion, boolean activo,
                       Carrera carrera, List<PlanMateria> planMaterias) {
        this.id = id;
        this.clave = clave;
        this.fechaAprobacion = fechaAprobacion;
        this.activo = activo;
        this.carrera = carrera;
        this.planMaterias = (planMaterias != null) ? planMaterias : new ArrayList<>();
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

    public LocalDate getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<PlanMateria> getPlanMaterias() {
        return planMaterias;
    }

    public void setPlanMaterias(List<PlanMateria> planMaterias) {
        this.planMaterias = (planMaterias != null) ? planMaterias : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PlanEstudio{" +
                "id=" + id +
                ", clave='" + clave + '\'' +
                ", fechaAprobacion=" + fechaAprobacion +
                ", activo=" + activo +
                ", carrera=" + (carrera != null ? carrera.getNombre() : "null") +
                '}';
    }
}