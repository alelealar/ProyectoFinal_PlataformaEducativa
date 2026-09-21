package com.example.plataformaEscolar.dominio;

import java.time.LocalTime;

/**
 * Representa el horario de una clase.
 * Guarda las horas, los días y la clase
 * correspondiente.
 *
 * @author Equipo 2 - Amarillo
 */
public class HorarioClase {

    /**
     * Hora de entrada de la clase.
     */
    private LocalTime horaEntrada;

    /**
     * Hora de salida de la clase.
     */
    private LocalTime horaSalida;

    /**
     * Días en los que se imparte la clase.
     */
    private String dias;

    /**
     * Clase a la que pertenece el horario.
     */
    private Clase clase;

    /**
     * Crea un horario vacío.
     */
    public HorarioClase() {
    }

    /**
     * Crea un horario con sus datos.
     *
     * @param horaEntrada hora de entrada
     * @param horaSalida hora de salida
     * @param dias días de la clase
     */
    public HorarioClase(LocalTime horaEntrada, LocalTime horaSalida,
                        String dias) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dias = dias;
    }

    /**
     * Crea un horario con todos sus datos.
     *
     * @param horaEntrada hora de entrada
     * @param horaSalida hora de salida
     * @param dias días de la clase
     * @param clase clase correspondiente
     */
    public HorarioClase(LocalTime horaEntrada, LocalTime horaSalida,
                        String dias, Clase clase) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dias = dias;
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
     * Regresa la clase correspondiente.
     *
     * @return clase del horario
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Cambia la clase correspondiente.
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
        return "HorarioClase{" +
                "horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", dias='" + dias + '\'' +
                ", clase=" + (clase != null ? clase.getNombre() : "N/A") +
                '}';
    }
}