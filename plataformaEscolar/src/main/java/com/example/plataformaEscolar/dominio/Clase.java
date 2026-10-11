package com.example.plataformaEscolar.dominio;

import java.util.List;

/**
 * Representa un grupo o sección aperturada de una materia en un periodo escolar determinado.
 * Gestiona la capacidad de alumnos, el maestro asignado, la materia y sus horarios.
 *
 * @author Equipo 2 - Amarillo
 */
public class Clase {

    /**
     * Identificador único de la clase.
     */
    private int id;

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
     * Cantidad de lugares disponibles para inscripción.
     */
    private int cupoDisponible;

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
     * Crea una clase vacía.
     */
    public Clase() {
    }

    /**
     * Crea una clase con todos sus datos completos.
     *
     * @param id identificador de la clase
     * @param nombre nombre de la clase
     * @param clave clave del grupo
     * @param cupoMaximo capacidad máxima de alumnos
     * @param cupoDisponible lugares disponibles
     * @param maestro maestro asignado
     * @param materia materia impartida
     * @param periodoEscolar período lectivo correspondiente
     * @param horarios bloques de horario de la clase
     */
    public Clase(int id, String nombre, String clave, int cupoMaximo, int cupoDisponible,
                 Maestro maestro, Materia materia, PeriodoEscolar periodoEscolar,
                 List<HorarioClase> horarios) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.cupoMaximo = cupoMaximo;
        this.cupoDisponible = cupoDisponible;
        this.maestro = maestro;
        this.materia = materia;
        this.periodoEscolar = periodoEscolar;
        this.horarios = horarios;
    }

    /**
     * Regresa el identificador de la clase.
     *
     * @return id de la clase
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador de la clase.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa el nombre de la clase.
     *
     * @return nombre de la clase
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la clase.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa la clave del grupo.
     *
     * @return clave de la clase
     */
    public String getClave() {
        return clave;
    }

    /**
     * Cambia la clave del grupo.
     *
     * @param clave nueva clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Regresa el cupo máximo.
     *
     * @return cupo máximo
     */
    public int getCupoMaximo() {
        return cupoMaximo;
    }

    /**
     * Cambia el cupo máximo.
     *
     * @param cupoMaximo nuevo cupo máximo
     */
    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    /**
     * Regresa la cantidad de cupos disponibles.
     *
     * @return cupo disponible
     */
    public int getCupoDisponible() {
        return cupoDisponible;
    }

    /**
     * Cambia la cantidad de cupos disponibles.
     *
     * @param cupoDisponible nuevo cupo disponible
     */
    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    /**
     * Regresa el maestro asignado.
     *
     * @return maestro de la clase
     */
    public Maestro getMaestro() {
        return maestro;
    }

    /**
     * Cambia el maestro asignado.
     *
     * @param maestro nuevo maestro
     */
    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    /**
     * Regresa la materia asociada.
     *
     * @return materia de la clase
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Cambia la materia asociada.
     *
     * @param materia nueva materia
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * Regresa el período escolar.
     *
     * @return período escolar de la clase
     */
    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    /**
     * Cambia el período escolar.
     *
     * @param periodoEscolar nuevo período escolar
     */
    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    /**
     * Regresa la lista de horarios de la clase.
     *
     * @return lista de bloques de horario
     */
    public List<HorarioClase> getHorarios() {
        return horarios;
    }

    /**
     * Cambia la lista de horarios de la clase.
     *
     * @param horarios nueva lista de horarios
     */
    public void setHorarios(List<HorarioClase> horarios) {
        this.horarios = horarios;
    }

    /**
     * Regresa la información de la clase en formato de texto.
     *
     * @return datos de la clase en texto
     */
    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", cupoMaximo=" + cupoMaximo +
                ", cupoDisponible=" + cupoDisponible +
                ", maestro=" + maestro +
                ", materia=" + materia +
                ", periodoEscolar=" + periodoEscolar +
                ", horarios=" + horarios +
                '}';
    }
}