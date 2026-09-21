package com.example.plataformaEscolar.dominio;

import java.time.LocalTime;

/**
 * Representa el horario de un maestro.
 * Guarda las horas, los días, el maestro
 * y la clase correspondiente.
 *
 * @author Equipo 2 - Amarillo
 */
public class HorarioMaestro {

    /**
     * Hora de entrada del maestro.
     */
    private LocalTime horaEntrada;

    /**
     * Hora de salida del maestro.
     */
    private LocalTime horaSalida;

    /**
     * Días en los que se imparte la clase.
     */
    private String dias;

    /**
     * Maestro al que pertenece el horario.
     */
    private Maestro maestro;

    /**
     * Clase correspondiente al horario.
     */
    private Clase clase;

    /**
     * Crea un horario vacío.
     */
    public HorarioMaestro() {
    }

    /**
     * Crea un horario con todos sus datos.
     *
     * @param horaEntrada hora de entrada
     * @param horaSalida hora de salida
     * @param dias días de la clase
     * @param maestro maestro del horario
     * @param clase clase correspondiente
     */
    public HorarioMaestro(LocalTime horaEntrada, LocalTime horaSalida,
                          String dias, Maestro maestro, Clase clase) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dias = dias;
        this.maestro = maestro;
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
     * Regresa el maestro.
     *
     * @return maestro del horario
     */
    public Maestro getMaestro() {
        return maestro;
    }

    /**
     * Cambia el maestro.
     *
     * @param maestro nuevo maestro
     */
    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
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
        return "HorarioMaestro{" +
                "horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", dias='" + dias + '\'' +
                ", maestro=" + (maestro != null ? maestro.getNombre() : "N/A") +
                ", clase=" + (clase != null ? clase.getNombre() : "N/A") +
                '}';
    }
}