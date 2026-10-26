package com.example.plataformaEscolar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una asignatura dentro del catálogo académico de la universidad.
 * Gestiona sus créditos, estado activo, grupos (clases) aperturados
 * y sus relaciones reflexivas de prerrequisitos (seriación múltiple).
 *
 * @author Equipo 2 - Amarillo
 */
public class Materia {

    /**
     * Identificador único de la materia.
     */
    private Long id; // Cambiado de int a Long

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
     * Lista de materias previas obligatorias que el alumno debe haber aprobado
     * para cursar esta asignatura (relación reflexiva de 1 a muchos).
     */
    private List<Materia> prerrequisitos;

    /**
     * Clases o grupos aperturados para esta materia.
     */
    private List<Clase> clases;

    /**
     * Crea una materia vacía e inicializa las listas requeridas.
     */
    public Materia() {
        this.prerrequisitos = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    /**
     * Crea una materia con sus datos principales.
     *
     * @param id identificador de la materia (Long)
     * @param nombre nombre de la materia
     * @param clave clave oficial
     * @param descripcion descripción del curso
     * @param creditos número de créditos
     */
    public Materia(Long id, String nombre, String clave, String descripcion, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.activa = true;
        this.prerrequisitos = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    /**
     * Crea una materia con todos sus datos completos, incluyendo su lista de prerrequisitos.
     *
     * @param id identificador de la materia (Long)
     * @param nombre nombre de la materia
     * @param clave clave oficial
     * @param descripcion descripción del curso
     * @param creditos número de créditos
     * @param activa estado activo de la materia
     * @param prerrequisitos lista de materias previas requeridas (seriación)
     * @param clases lista de clases asociadas
     */
    public Materia(Long id, String nombre, String clave, String descripcion, int creditos,
                   boolean activa, List<Materia> prerrequisitos, List<Clase> clases) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.activa = activa;
        this.prerrequisitos = (prerrequisitos != null) ? prerrequisitos : new ArrayList<>();
        this.clases = (clases != null) ? clases : new ArrayList<>();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Regresa la lista de materias asignadas como prerrequisito.
     *
     * @return lista de materias prerrequisito
     */
    public List<Materia> getPrerrequisitos() {
        return prerrequisitos;
    }

    /**
     * Asigna una lista completa de materias prerrequisito.
     *
     * @param prerrequisitos nueva lista de prerrequisitos
     */
    public void setPrerrequisitos(List<Materia> prerrequisitos) {
        this.prerrequisitos = (prerrequisitos != null) ? prerrequisitos : new ArrayList<>();
    }

    /**
     * Agrega un nuevo prerrequisito a la lista si no es nulo y no está ya presente.
     *
     * @param prerrequisito materia requerida a agregar
     */
    public void agregarPrerrequisito(Materia prerrequisito) {
        if (prerrequisito != null && !this.prerrequisitos.contains(prerrequisito)) {
            this.prerrequisitos.add(prerrequisito);
        }
    }

    /**
     * Elimina un prerrequisito de la lista.
     *
     * @param prerrequisito materia requerida a remover
     */
    public void eliminarPrerrequisito(Materia prerrequisito) {
        this.prerrequisitos.remove(prerrequisito);
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = (clases != null) ? clases : new ArrayList<>();
    }

    @Override
    public String toString() {
        List<String> nombresPrerrequisitos = new ArrayList<>();
        for (Materia p : prerrequisitos) {
            nombresPrerrequisitos.add(p.getNombre());
        }

        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", creditos=" + creditos +
                ", activa=" + activa +
                ", prerrequisitos=" + (nombresPrerrequisitos.isEmpty() ? "Ninguno" : nombresPrerrequisitos) +
                '}';
    }
}