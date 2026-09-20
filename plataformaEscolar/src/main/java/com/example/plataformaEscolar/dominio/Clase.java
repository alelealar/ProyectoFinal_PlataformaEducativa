package com.example.plataformaEscolar.dominio;

public class Clase {

    private String nombre;
    private String clave;
    //private double creditos;
    private Horario horario;
    private int cupoMax;
    private Maestro maestroResponsable;

    public Clase() {
    }

    public Clase(String nombre, String clave, Horario horario, int cupoMax, Maestro maestroResponsable) {
        this.nombre = nombre;
        this.clave = clave;
        this.horario = horario;
        this.cupoMax = cupoMax;
        this.maestroResponsable = maestroResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public Maestro getMaestroResponsable() {
        return maestroResponsable;
    }

    public void setMaestroResponsable(Maestro maestroResponsable) {
        this.maestroResponsable = maestroResponsable;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", horario=" + horario +
                ", cupoMax=" + cupoMax +
                ", maestroResponsable=" + maestroResponsable +
                '}';
    }
}
