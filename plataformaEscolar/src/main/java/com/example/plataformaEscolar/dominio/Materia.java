package com.example.plataformaEscolar.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una materia de la plataforma escolar.
 * Contiene su información básica y las clases
 * relacionadas con ella.
 *
 * @author Equipo 2 - Amarillo
 */
public class Materia {

    /**
     * Nombre de la materia.
     */
    private String nombre;

    /**
     * Clave de la materia.
     */
    private String clave;

    /**
     * Descripción de la materia.
     */
    private String descripcion;

    /**
     * Número de créditos de la materia.
     */
    private int creditos;

    /**
     * Indica si la materia está activa.
     */
    private boolean activa;

    /**
     * Clases relacionadas con la materia.
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
     * @param nombre nombre de la materia
     * @param clave clave de la materia
     * @param descripcion descripción de la materia
     * @param creditos número de créditos
     */
    public Materia(String nombre, String clave,
                   String descripcion, int creditos) {
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.activa = true;
        this.clases = new ArrayList<>();
    }

    /**
     * Crea una materia con todos sus datos.
     *
     * @param nombre nombre de la materia
     * @param clave clave de la materia
     * @param descripcion descripción de la materia
     * @param creditos número de créditos
     * @param activa indica si la materia está activa
     * @param clases clases relacionadas con la materia
     */
    public Materia(String nombre, String clave,
                   String descripcion, int creditos,
                   boolean activa, List<Clase> clases) {
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.activa = activa;
        this.clases = (clases != null) ? clases : new ArrayList<>();
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
     * @param descripcion nueva descripción de la materia
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
     * @param activa nuevo estado de la materia
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Regresa las clases de la materia.
     *
     * @return lista de clases
     */
    public List<Clase> getClases() {
        return clases;
    }

    /**
     * Cambia las clases de la materia.
     *
     * @param clases nueva lista de clases
     */
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    /**
     * Regresa la información de la materia.
     *
     * @return datos de la materia en texto
     */
    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", creditos=" + creditos +
                ", activa=" + activa +
                '}';
    }
}