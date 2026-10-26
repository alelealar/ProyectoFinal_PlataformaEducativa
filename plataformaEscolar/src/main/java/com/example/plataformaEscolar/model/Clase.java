package com.example.plataformaEscolar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un grupo o sección aperturada de una materia en un periodo escolar determinado.
 * Gestiona la capacidad de alumnos, el maestro asignado, la materia, sus horarios y sus inscripciones.
 *
 * @author Equipo 2 - Amarillo
 */
public class Clase {

    /**
     * Identificador único de la clase.
     */
    private Long id; // Cambiado de int a Long

    /**
     * Nombre descriptivo de la clase o grupo.
     */
    private String nombre;

    /**
     * Clave única que identifica al grupo.
     */
    private String clave;

    /**
     * Cupo máximo permitido de alumnos en el grupo.
     */
    private int cupoMaximo;

    /**
     * Maestro responsable de impartir la clase.
     */
    private Maestro maestro;

    /**
     * Materia asociada a la clase.
     */
    private Materia materia;

    /**
     * Período escolar en el que se imparte la clase.
     */
    private PeriodoEscolar periodoEscolar;

    /**
     * Lista de horarios en los que se imparte la clase.
     */
    private List<HorarioClase> horarios;

    /**
     * Lista de inscripciones activas vinculadas a esta clase.
     */
    private List<Inscripcion> inscripciones;

    /**
     * Crea una clase vacía e inicializa sus colecciones.
     */
    public Clase() {
        this.horarios = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Crea una clase con sus datos principales sin inscripciones previas.
     *
     * @param id identificador de la clase (Long)
     * @param nombre nombre de la clase
     * @param clave clave del grupo
     * @param cupoMaximo capacidad máxima de alumnos
     * @param maestro maestro asignado
     * @param materia materia impartida
     * @param periodoEscolar período lectivo correspondiente
     * @param horarios bloques de horario de la clase
     */
    public Clase(Long id, String nombre, String clave, int cupoMaximo,
                 Maestro maestro, Materia materia, PeriodoEscolar periodoEscolar,
                 List<HorarioClase> horarios) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.cupoMaximo = cupoMaximo;
        this.maestro = maestro;
        this.materia = materia;
        this.periodoEscolar = periodoEscolar;
        this.horarios = (horarios != null) ? horarios : new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Crea una clase con todos sus datos completos, incluyendo inscripciones existentes.
     *
     * @param id identificador de la clase (Long)
     * @param nombre nombre de la clase
     * @param clave clave del grupo
     * @param cupoMaximo capacidad máxima de alumnos
     * @param maestro maestro asignado
     * @param materia materia impartida
     * @param periodoEscolar período lectivo correspondiente
     * @param horarios bloques de horario de la clase
     * @param inscripciones lista de inscripciones de la clase
     */
    public Clase(Long id, String nombre, String clave, int cupoMaximo,
                 Maestro maestro, Materia materia, PeriodoEscolar periodoEscolar,
                 List<HorarioClase> horarios, List<Inscripcion> inscripciones) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.cupoMaximo = cupoMaximo;
        this.maestro = maestro;
        this.materia = materia;
        this.periodoEscolar = periodoEscolar;
        this.horarios = (horarios != null) ? horarios : new ArrayList<>();
        this.inscripciones = (inscripciones != null) ? inscripciones : new ArrayList<>();
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    /**
     * Regresa la cantidad de cupos disponibles calculada de forma dinámica.
     * Cuenta únicamente las inscripciones activas (diferentes de BAJA).
     *
     * @return lugares disponibles (cupoMáximo - inscripciones activas)
     */
    public int getCupoDisponible() {
        int inscritosActivos = 0;
        if (inscripciones != null) {
            for (Inscripcion inscripcion : inscripciones) {
                if (inscripcion.getEstado() != EstadoInscripcion.BAJA) {
                    inscritosActivos++;
                }
            }
        }
        int disponibles = cupoMaximo - inscritosActivos;
        return Math.max(disponibles, 0);
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    public List<HorarioClase> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioClase> horarios) {
        this.horarios = (horarios != null) ? horarios : new ArrayList<>();
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = (inscripciones != null) ? inscripciones : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", cupoMaximo=" + cupoMaximo +
                ", cupoDisponible=" + getCupoDisponible() +
                ", maestro=" + (maestro != null ? maestro.getCorreo() : "null") +
                ", materia=" + (materia != null ? materia.getNombre() : "null") +
                ", periodoEscolar=" + (periodoEscolar != null ? periodoEscolar.getNombrePeriodo() : "null") +
                '}';
    }
}