package com.example.plataformaEscolar.dominio;

import java.time.LocalTime;

/**
 * Representa el horario de un alumno.
 * Guarda las horas, los días, el alumno
 * y la clase correspondiente.
 *
 * @author Equipo 2 - Amarillo
 */
public class HorarioAlumno {

    /**
     * Hora de entrada del alumno.
     */
    private LocalTime horaEntrada;

    /**
     * Hora de salida del alumno.
     */
    private LocalTime horaSalida;

    /**
     * Días en los que tiene la clase.
     */
    private String dias;

    /**
     * Alumno al que pertenece el horario.
     */
    private Alumno alumno;

    /**
     * Clase correspondiente al horario.
     */
    private Clase clase;

    /**
     * Crea un horario vacío.
     */
    public HorarioAlumno() {

    }

    /**
     * Crea un horario con todos sus datos.
     *
     * @param horaEntrada hora de entrada
     * @param horaSalida hora de salida
     * @param dias días de la clase
     * @param alumno alumno del horario
     * @param clase clase correspondiente
     */
    public HorarioAlumno(LocalTime horaEntrada, LocalTime horaSalida,
                         String dias, Alumno alumno, Clase clase) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dias = dias;
        this.alumno = alumno;
        this.clase = clase;
    }

    /**
     * Regresa la hora de entrada.
     *
     * @return hora de entrada
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Cambia la hora de entrada.
     *
     * @param horaEntrada nueva hora de entrada
     */
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Regresa la hora de salida.
     *
     * @return hora de salida
     */
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Cambia la hora de salida.
     *
     * @param horaSalida nueva hora de salida
     */
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Regresa los días de la clase.
     *
     * @return días de la clase
     */
    public String getDias() {
        return dias;
    }

    /**
     * Cambia los días de la clase.
     *
     * @param dias nuevos días de la clase
     */
    public void setDias(String dias) {
        this.dias = dias;
    }

    /**
     * Regresa el alumno.
     *
     * @return alumno del horario
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Cambia el alumno.
     *
     * @param alumno nuevo alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Regresa la clase.
     *
     * @return clase correspondiente
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Cambia la clase.
     *
     * @param clase nueva clase
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }

    /**
     * Regresa la información del horario.
     *
     * @return datos del horario en texto
     */
    @Override
    public String toString() {
        return "HorarioAlumno{" +
                "horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", dias='" + dias + '\'' +
                ", alumno=" + alumno +
                ", clase=" + clase +
                '}';
    }
}