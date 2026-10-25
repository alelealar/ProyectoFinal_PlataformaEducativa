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
    private int id;

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
     * @param id identificador del horario
     * @param horaEntrada hora de inicio
     * @param horaSalida hora de fin
     * @param dias días en los que aplica
     * @param aula aula asignada
     * @param clase clase correspondiente
     */
    public HorarioClase(int id, LocalTime horaEntrada, LocalTime horaSalida,
                        String dias, String aula, Clase clase) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dias = dias;
        this.aula = aula;
        this.clase = clase;
    }

    /**
     * Regresa el identificador del horario.
     *
     * @return id del horario
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador del horario.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
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
     * @return días asignados
     */
    public String getDias() {
        return dias;
    }

    /**
     * Cambia los días de la clase.
     *
     * @param dias nuevos días
     */
    public void setDias(String dias) {
        this.dias = dias;
    }

    /**
     * Regresa el aula asignada.
     *
     * @return aula de la clase
     */
    public String getAula() {
        return aula;
    }

    /**
     * Cambia el aula asignada.
     *
     * @param aula nueva aula
     */
    public void setAula(String aula) {
        this.aula = aula;
    }

    /**
     * Regresa la clase asociada.
     *
     * @return clase correspondiente
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Cambia la clase asociada.
     *
     * @param clase nueva clase
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }

    /**
     * Regresa la información del horario de clase en texto.
     *
     * @return datos del horario en texto
     */
    @Override
    public String toString() {
        return "HorarioClase{" +
                "id=" + id +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", dias='" + dias + '\'' +
                ", aula='" + aula + '\'' +
                ", clase=" + clase +
                '}';
    }
}