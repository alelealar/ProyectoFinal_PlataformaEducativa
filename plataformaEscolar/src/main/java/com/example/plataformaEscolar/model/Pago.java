package com.example.plataformaEscolar.model;

import java.time.LocalDateTime;

/**
 * Representa el comprobante de pago realizado por un alumno para habilitar su proceso de inscripción.
 *
 * @author Equipo 2 - Amarillo
 */
public class Pago {

    /**
     * Identificador único de la transacción de pago.
     */
    private int id;

    /**
     * Folio o número de referencia bancaria/sistema.
     */
    private String folio;

    /**
     * Monto total cubierto.
     */
    private double monto;

    /**
     * Fecha y hora en la que se registró el pago.
     */
    private LocalDateTime fechaPago;

    /**
     * Estado del pago (ej. "APROBADO", "PENDIENTE", "RECHAZADO").
     */
    private String estado;

    /**
     * Alumno que efectúa el pago.
     */
    private Alumno alumno;

    /**
     * Crea un pago vacío.
     */
    public Pago() {
    }

    /**
     * Crea un pago con todos sus datos completos.
     *
     * @param id identificador del pago
     * @param folio número de folio del recibo
     * @param monto cantidad pagada
     * @param fechaPago fecha y hora de la transacción
     * @param estado estado del pago
     * @param alumno alumno responsable
     */
    public Pago(int id, String folio, double monto, LocalDateTime fechaPago, String estado, Alumno alumno) {
        this.id = id;
        this.folio = folio;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.alumno = alumno;
    }

    /**
     * Regresa el identificador del pago.
     *
     * @return id del pago
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador del pago.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa el folio del pago.
     *
     * @return folio del recibo
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Cambia el folio del pago.
     *
     * @param folio nuevo folio
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Regresa el monto del pago.
     *
     * @return monto pagado
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Cambia el monto del pago.
     *
     * @param monto nuevo monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Regresa la fecha y hora del pago.
     *
     * @return fecha y hora
     */
    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    /**
     * Cambia la fecha y hora del pago.
     *
     * @param fechaPago nueva fecha y hora
     */
    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Regresa el estado del pago.
     *
     * @return estado del pago
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Cambia el estado del pago.
     *
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa el alumno que realizó el pago.
     *
     * @return alumno responsable
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Cambia el alumno responsable del pago.
     *
     * @param alumno nuevo alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Regresa la información del pago en texto.
     *
     * @return representación en cadena del pago
     */
    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", folio='" + folio + '\'' +
                ", monto=" + monto +
                ", fechaPago=" + fechaPago +
                ", estado='" + estado + '\'' +
                '}';
    }
}