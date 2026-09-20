package com.example.plataformaEscolar.dominio;

/**
 * Representa un periodo escolar en la plataforma.
 * Define las fechas de inicio y fin, así como la denominación del periodo.
 *
 * @author Equipo 2 - Amarillo
 */
public class PeriodoEscolar {

    /** Fecha de inicio del periodo escolar. */
    private String fechaInicio;

    /** Fecha de finalización del periodo escolar. */
    private String fechaFin;

    /** Nombre o identificador del periodo. */
    private String periodo;

    /**
     * Crea un periodo escolar sin datos iniciales.
     */
    public PeriodoEscolar() {
    }

    /**
     * Crea un periodo escolar con todos sus datos.
     *
     * @param fechaInicio fecha de inicio del periodo
     * @param fechaFin fecha de fin del periodo
     * @param periodo nombre o identificador del periodo
     */
    public PeriodoEscolar(String fechaInicio, String fechaFin, String periodo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.periodo = periodo;
    }

    /**
     * Obtiene la fecha de inicio del periodo.
     *
     * @return fecha de inicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del periodo.
     *
     * @param fechaInicio nueva fecha de inicio
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del periodo.
     *
     * @return fecha de fin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del periodo.
     *
     * @param fechaFin nueva fecha de fin
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el nombre del periodo.
     *
     * @return nombre del periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Establece el nombre del periodo.
     *
     * @param periodo nuevo nombre del periodo
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * Devuelve una representación en texto del periodo escolar.
     *
     * @return representación en texto del periodo escolar
     */
    @Override
    public String toString() {
        return "PeriodoEscolar{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
