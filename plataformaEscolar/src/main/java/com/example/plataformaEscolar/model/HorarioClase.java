package com.example.plataformaEscolar.model;

import java.time.LocalTime;

/**
 * Representa el bloque de horario y aula asignados a una clase en particular.
 * Permite validar la concurrencia de horarios y evitar empalmes en la carga del alumno.
 *
 * @author Equipo 2 - Amarillo
 */
public class HorarioClase {

    /**
     * Identificador único del horario.
     */
    private Long id; // Cambiado de int a Long

    /**
     * Hora de inicio de la sesión.
     */
    private LocalTime horaEntrada;

    /**
     * Hora de finalización de la sesión.
     */
    private LocalTime horaSalida;

    /**
     * Días de la semana en los que se imparte la clase (ej. "Lunes, Miércoles").
     */
    private String dias;

    /**
     * Aula o laboratorio asignado.
     */
    private String aula;

    /**
     * Clase a la que pertenece este horario.
     */
    private Clase clase;

    /**
     * Crea un horario de clase vacío.
     */
    public HorarioClase() {
    }

    /**
     * Crea un horario de clase con todos sus datos completos.
     *
     * @param id identificador del horario (Long)
     * @param horaEntrada hora de inicio
     * @param horaSalida hora de fin
     * @param dias días en los que aplica
     * @param aula aula asignada
     * @param clase clase correspondiente
     */
    public HorarioClase(Long id, LocalTime horaEntrada, LocalTime horaSalida,
                        String dias, String aula, Clase clase) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dias = dias;
        this.aula = aula;
        this.clase = clase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "HorarioClase{" +
                "id=" + id +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", dias='" + dias + '\'' +
                ", aula='" + aula + '\'' +
                ", clase=" + (clase != null ? clase.getClave() : "null") +
                '}';
    }
}