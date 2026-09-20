package com.example.plataformaEscolar.dominio;

/**
 * Representa una materia dentro de la plataforma escolar.
 * Contiene la información básica de una materia, como su nombre,
 * clave, descripción y número de créditos.
 *
 * @author Equipo 2 - Amarillo
 */
public class Materia {

    /** Nombre de la materia. */
    private String nombre;

    /** Clave que identifica a la materia. */
    private String clave;

    /** Descripción de la materia. */
    private String descripcion;

    /** Número de créditos que tiene la materia. */
    private int creditos;

    /**
     * Crea una materia sin datos iniciales.
     */
    public Materia() {
    }

    /**
     * Crea una materia con todos sus datos.
     *
     * @param nombre nombre de la materia
     * @param clave clave que identifica a la materia
     * @param descripcion descripción de la materia
     * @param creditos número de créditos de la materia
     */
    public Materia(String nombre, String clave, String descripcion, int creditos) {
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
    }

    /**
     * Obtiene el nombre de la materia.
     *
     * @return nombre de la materia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la materia.
     *
     * @param nombre nuevo nombre de la materia
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la clave de la materia.
     *
     * @return clave de la materia
     */
    public String getClave() {
        return clave;
    }

    /**
     * Establece la clave de la materia.
     *
     * @param clave nueva clave de la materia
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Obtiene la descripción de la materia.
     *
     * @return descripción de la materia
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la materia.
     *
     * @param descripcion nueva descripción de la materia
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el número de créditos de la materia.
     *
     * @return número de créditos de la materia
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Establece el número de créditos de la materia.
     *
     * @param creditos nuevo número de créditos de la materia
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Devuelve una representación en texto de la materia.
     *
     * @return representación en texto de la materia
     */
    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}