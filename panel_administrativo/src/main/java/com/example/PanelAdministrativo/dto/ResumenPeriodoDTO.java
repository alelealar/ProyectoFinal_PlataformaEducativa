package com.example.PanelAdministrativo.dto;

/**
 * Datos calculados del periodo escolar activo para la vista de periodos escolares.
 * Si no hay periodo activo, todos los valores quedan en cero.
 */
public class ResumenPeriodoDTO {

    private long matriculados;
    private int semanaActual;
    private int totalSemanas;
    private int porcentajeAvance;
    private int porcentajeAforo;
    private long docentesAsignados;
    private long periodosArchivados;

    public long getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(long matriculados) {
        this.matriculados = matriculados;
    }

    public int getSemanaActual() {
        return semanaActual;
    }

    public void setSemanaActual(int semanaActual) {
        this.semanaActual = semanaActual;
    }

    public int getTotalSemanas() {
        return totalSemanas;
    }

    public void setTotalSemanas(int totalSemanas) {
        this.totalSemanas = totalSemanas;
    }

    public int getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(int porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public int getPorcentajeAforo() {
        return porcentajeAforo;
    }

    public void setPorcentajeAforo(int porcentajeAforo) {
        this.porcentajeAforo = porcentajeAforo;
    }

    public long getDocentesAsignados() {
        return docentesAsignados;
    }

    public void setDocentesAsignados(long docentesAsignados) {
        this.docentesAsignados = docentesAsignados;
    }

    public long getPeriodosArchivados() {
        return periodosArchivados;
    }

    public void setPeriodosArchivados(long periodosArchivados) {
        this.periodosArchivados = periodosArchivados;
    }
}
