package com.example.plataformaEscolar.dominio;

import java.util.List;

/**
 * Representa una clase de la plataforma escolar.
 * Guarda su información, horario, maestro
 * y alumnos relacionados.
 *
 * @author Equipo 2 - Amarillo
 */
public class Clase {

    /**
     * Nombre de la clase.
     */
    private String nombre;

    /**
     * Clave de la clase.
     */
    private String clave;

    /**
     * Cupo máximo de la clase.
     */
    private int cupoMax;

    /**
     * Maestro responsable de la clase.
     */
    private Maestro maestroResponsable;

    /**
     * Materia de la clase.
     */
    private Materia materia;

    /**
     * Horario de la clase.
     */
    private HorarioClase horario;

    /**
     * Horarios del maestro.
     */
    private List<HorarioMaestro> horariosMaestro;

    /**
     * Horarios de los alumnos.
     */
    private List<HorarioAlumno> horariosAlumno;

    /**
     * Crea una clase vacía.
     */
    public Clase() {
    }

    /**
     * Crea una clase con sus horarios.
     *
     * @param horariosMaestro horarios del maestro
     * @param horariosAlumno horarios de los alumnos
     */
    public Clase(List<HorarioMaestro> horariosMaestro,
                 List<HorarioAlumno> horariosAlumno) {
        this.horariosMaestro = horariosMaestro;
        this.horariosAlumno = horariosAlumno;
    }

    /**
     * Crea una clase con todos sus datos.
     *
     * @param nombre nombre de la clase
     * @param clave clave de la clase
     * @param horario horario de la clase
     * @param cupoMax cupo máximo
     * @param maestroResponsable maestro responsable
     * @param materia materia de la clase
     * @param horariosMaestro horarios del maestro
     * @param horariosAlumno horarios de los alumnos
     */
    public Clase(String nombre, String clave,
                 HorarioClase horario, int cupoMax,
                 Maestro maestroResponsable,
                 Materia materia,
                 List<HorarioMaestro> horariosMaestro,
                 List<HorarioAlumno> horariosAlumno) {
        this.nombre = nombre;
        this.clave = clave;
        this.horario = horario;
        this.cupoMax = cupoMax;
        this.maestroResponsable = maestroResponsable;
        this.materia = materia;
        this.horariosMaestro = horariosMaestro;
        this.horariosAlumno = horariosAlumno;
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
     * Regresa la clave de la clase.
     *
     * @return clave de la clase
     */
    public String getClave() {
        return clave;
    }

    /**
     * Cambia la clave de la clase.
     *
     * @param clave nueva clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Regresa el horario de la clase.
     *
     * @return horario de la clase
     */
    public HorarioClase getHorario() {
        return horario;
    }

    /**
     * Cambia el horario de la clase.
     *
     * @param horario nuevo horario
     */
    public void setHorario(HorarioClase horario) {
        this.horario = horario;
    }

    /**
     * Regresa el cupo máximo.
     *
     * @return cupo máximo de la clase
     */
    public int getCupoMax() {
        return cupoMax;
    }

    /**
     * Cambia el cupo máximo.
     *
     * @param cupoMax nuevo cupo máximo
     */
    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    /**
     * Regresa el maestro responsable.
     *
     * @return maestro responsable
     */
    public Maestro getMaestroResponsable() {
        return maestroResponsable;
    }

    /**
     * Cambia el maestro responsable.
     *
     * @param maestroResponsable nuevo maestro responsable
     */
    public void setMaestroResponsable(Maestro maestroResponsable) {
        this.maestroResponsable = maestroResponsable;
    }

    /**
     * Regresa la materia de la clase.
     *
     * @return materia de la clase
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Cambia la materia de la clase.
     *
     * @param materia nueva materia
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * Regresa los horarios del maestro.
     *
     * @return lista de horarios del maestro
     */
    public List<HorarioMaestro> getHorariosMaestro() {
        return horariosMaestro;
    }

    /**
     * Cambia los horarios del maestro.
     *
     * @param horariosMaestro nueva lista de horarios
     */
    public void setHorariosMaestro(List<HorarioMaestro> horariosMaestro) {
        this.horariosMaestro = horariosMaestro;
    }

    /**
     * Regresa los horarios de los alumnos.
     *
     * @return lista de horarios de los alumnos
     */
    public List<HorarioAlumno> getHorariosAlumno() {
        return horariosAlumno;
    }

    /**
     * Cambia los horarios de los alumnos.
     *
     * @param horariosAlumno nueva lista de horarios
     */
    public void setHorariosAlumno(List<HorarioAlumno> horariosAlumno) {
        this.horariosAlumno = horariosAlumno;
    }

    /**
     * Regresa la información de la clase.
     *
     * @return datos de la clase en texto
     */
    @Override
    public String toString() {
        return "Clase{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", horario=" + horario +
                ", cupoMax=" + cupoMax +
                ", maestroResponsable=" + maestroResponsable +
                ", materia=" + materia +
                ", horariosMaestro=" + horariosMaestro +
                ", horariosAlumno=" + horariosAlumno +
                '}';
    }
}