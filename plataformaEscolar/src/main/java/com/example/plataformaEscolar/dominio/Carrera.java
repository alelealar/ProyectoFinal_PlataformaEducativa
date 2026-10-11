package com.example.plataformaEscolar.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa el programa académico o carrera universitaria a la que pertenece un alumno.
 *
 * @author Equipo 2 - Amarillo
 */
public class Carrera {

    /**
     * Identificador único de la carrera.
     */
    private int id;

    /**
     * Clave oficial de la carrera.
     */
    private String clave;

    /**
     * Nombre completo del programa educativo.
     */
    private String nombre;

    /**
     * Plan de estudios al que corresponden las materias ofertadas.
     */
    private List<Materia> materias;

    /**
     * Crea una carrera vacía.
     */
    public Carrera() {
        this.materias = new ArrayList<>();
    }

    /**
     * Crea una carrera con sus datos principales.
     *
     * @param id identificador de la carrera
     * @param clave clave oficial
     * @param nombre nombre de la carrera
     */
    public Carrera(int id, String clave, String nombre) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    /**
     * Regresa el identificador de la carrera.
     *
     * @return id de la carrera
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador de la carrera.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa la clave de la carrera.
     *
     * @return clave de la carrera
     */
    public String getClave() {
        return clave;
    }

    /**
     * Cambia la clave de la carrera.
     *
     * @param clave nueva clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Regresa el nombre de la carrera.
     *
     * @return nombre de la carrera
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la carrera.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el plan de materias asociadas a la carrera.
     *
     * @return lista de materias
     */
    public List<Materia> getMaterias() {
        return materias;
    }

    /**
     * Cambia el plan de materias de la carrera.
     *
     * @param materias nueva lista de materias
     */
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    /**
     * Regresa la información de la carrera en texto.
     *
     * @return representación en cadena de la carrera
     */
    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}