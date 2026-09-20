package com.example.plataformaEscolar.dominio;

/**
 * Representa el horario asignado para una clase.
 * Define la hora de entrada, salida y el día correspondiente.
 *
 * @author Equipo 2 - Amarillo
 */
public class Horario {

    /** Hora de entrada de la clase. */
    private String horaEntrada;

    /** Hora de salida de la clase. */
    private String horaSalida;

    /** Día de la semana en que se imparte la clase. */
    private String dia;

    /**
     * Crea un horario sin datos iniciales.
     */
    public Horario() {
    }

    /**
     * Crea un horario con todos sus datos.
     *
     * @param horaEntrada hora de inicio de la clase
     * @param horaSalida hora de finalización de la clase
     * @param dia día de la semana
     */
    public Horario(String horaEntrada, String horaSalida, String dia) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.dia = dia;
    }

    /**
     * Obtiene la hora de entrada.
     *
     * @return hora de entrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Establece la hora de entrada.
     *
     * @param horaEntrada nueva hora de entrada
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Obtiene la hora de salida.
     *
     * @return hora de salida
     */
    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     * Establece la hora de salida.
     *
     * @param horaSalida nueva hora de salida
     */
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Obtiene el día del horario.
     *
     * @return día de la semana
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día del horario.
     *
     * @param dia nuevo día de la semana
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Devuelve una representación en texto del horario.
     *
     * @return representación en texto del horario
     */
    @Override
    public String toString() {
        return "Horario{" +
                "horaEntrada='" + horaEntrada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", dia='" + dia + '\'' +
                '}';
    }
}
