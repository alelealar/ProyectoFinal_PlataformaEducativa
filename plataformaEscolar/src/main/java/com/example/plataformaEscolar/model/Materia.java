package com.example.plataformaEscolar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una asignatura dentro del catálogo académico de la universidad.
 * Gestiona sus créditos, estado activo, grupos (clases) aperturados
 * y su relación reflexiva de prerrequisito (seriación).
 *
 * @author Equipo 2 - Amarillo
 */
public class Materia {

    /**
     * Identificador único de la materia.
     */
    private int id;

    /**
     * Nombre de la materia.
     */
    private String nombre;

    /**
     * Clave oficial de la materia.
     */
    private String clave;

    /**
     * Descripción del contenido o propósito de la materia.
     */
    private String descripcion;

    /**
     * Número de créditos académicos que otorga la materia.
     */
    private int creditos;

    /**
     * Indica si la materia se encuentra disponible en el catálogo activo.
     */
    private boolean activa;

    /**
     * Materia previa obligatoria que el alumno debe haber aprobado para cursar esta asignación (relación reflexiva).
     */
    private Materia prerrequisito;

    /**
     * Clases o grupos aperturados para esta materia.
     */
    private List<Clase> clases;

    /**
     * Crea una materia vacía.
     */
    public Materia() {
        this.clases = new ArrayList<>();
    }

    /**
     * Crea una materia con sus datos principales.
     *
     * @param id identificador de la materia
     * @param nombre nombre de la materia
     * @param clave clave oficial
     * @param descripcion descripción del curso
     * @param creditos número de créditos
     */
    public Materia(int id, String nombre, String clave, String descripcion, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.activa = true;
        this.clases = new ArrayList<>();
    }

    /**
     * Crea una materia con todos sus datos completos, incluyendo su prerrequisito.
     *
     * @param id identificador de la materia
     * @param nombre nombre de la materia
     * @param clave clave oficial
     * @param descripcion descripción del curso
     * @param creditos número de créditos
     * @param activa estado activo de la materia
     * @param prerrequisito materia previa requerida (seriación)
     * @param clases lista de clases asociadas
     */
    public Materia(int id, String nombre, String clave, String descripcion, int creditos,
                   boolean activa, Materia prerrequisito, List<Clase> clases) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.activa = activa;
        this.prerrequisito = prerrequisito;
        this.clases = (clases != null) ? clases : new ArrayList<>();
    }

    /**
     * Regresa el identificador de la materia.
     *
     * @return id de la materia
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador de la materia.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa el nombre de la materia.
     *
     * @return nombre de la materia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la materia.
     *
     * @param nombre nuevo nombre de la materia
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa la clave de la materia.
     *
     * @return clave de la materia
     */
    public String getClave() {
        return clave;
    }

    /**
     * Cambia la clave de la materia.
     *
     * @param clave nueva clave de la materia
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Regresa la descripción de la materia.
     *
     * @return descripción de la materia
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripción de la materia.
     *
     * @param descripcion nueva descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Regresa los créditos de la materia.
     *
     * @return número de créditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Cambia los créditos de la materia.
     *
     * @param creditos nuevo número de créditos
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Indica si la materia está activa.
     *
     * @return true si está activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Cambia el estado de la materia.
     *
     * @param activa nuevo estado
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Regresa la materia asignada como prerrequisito.
     *
     * @return materia prerrequisito
     */
    public Materia getPrerrequisito() {
        return prerrequisito;
    }

    /**
     * Cambia o asigna la materia prerrequisito.
     *
     * @param prerrequisito nueva materia prerrequisito
     */
    public void setPrerrequisito(Materia prerrequisito) {
        this.prerrequisito = prerrequisito;
    }

    /**
     * Regresa las clases o grupos de la materia.
     *
     * @return lista de clases
     */
    public List<Clase> getClases() {
        return clases;
    }

    /**
     * Cambia la lista de clases de la materia.
     *
     * @param clases nueva lista de clases
     */
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    /**
     * Regresa la información de la materia en formato de texto.
     *
     * @return datos de la materia en texto
     */
    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", creditos=" + creditos +
                ", activa=" + activa +
                ", prerrequisito=" + (prerrequisito != null ? prerrequisito.getNombre() : "Ninguno") +
                '}';
    }
}