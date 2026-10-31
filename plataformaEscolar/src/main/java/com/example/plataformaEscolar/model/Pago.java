package com.example.plataformaEscolar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa el comprobante de pago realizado por un alumno para habilitar su proceso de inscripción.
 *
 * @author Equipo 2 - Amarillo
 */
@Entity
public class Pago {

    /**
     * Identificador único de la transacción de pago.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado de int a Long

    /**
     * Folio o número de referencia bancaria/sistema.
     */
    @NotBlank(message = "el folio no puede estar vacio")
    private String folio;

    /**
     * Monto total cubierto.
     */
    private BigDecimal monto;

    /**
     * Método utilizado para realizar el pago mediante enumeración.
     */
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    /**
     * Concepto o motivo del pago (ej. "Inscripción", "Colegiatura").
     */
    @NotBlank(message = "El concepto no puede estar vacio")
    private String concepto;

    /**
     * Fecha y hora en la que se registró el pago.
     */
    @PastOrPresent(message = "La fecha de pago no puede ser futura")
    private LocalDateTime fechaPago;

    /**
     * Estado del pago (ej. "APROBADO", "PENDIENTE", "RECHAZADO").
     */
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    /**
     * Alumno que efectúa el pago.
     */
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    /**
     * Período escolar correspondiente al pago.
     */
    private PeriodoEscolar periodoEscolar;

    /**
     * Crea un pago vacío con el monto inicializado en cero.
     */
    public Pago() {
        this.monto = BigDecimal.ZERO;
    }

    /**
     * Crea un pago con todos sus datos completos.
     *
     * @param id identificador del pago (Long)
     * @param folio número de folio del recibo
     * @param monto cantidad pagada
     * @param metodoPago método de pago utilizado (enum)
     * @param concepto concepto del pago
     * @param fechaPago fecha y hora de la transacción
     * @param estado estado del pago
     * @param alumno alumno responsable
     * @param periodoEscolar período escolar al que corresponde el pago
     */
    public Pago(Long id, String folio, BigDecimal monto, MetodoPago metodoPago, String concepto,
                LocalDateTime fechaPago, EstadoPago estado, Alumno alumno, PeriodoEscolar periodoEscolar) {
        this.id = id;
        this.folio = folio;
        this.monto = (monto != null) ? monto : BigDecimal.ZERO;
        this.metodoPago = metodoPago;
        this.concepto = concepto;
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.alumno = alumno;
        this.periodoEscolar = periodoEscolar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = (monto != null) ? monto : BigDecimal.ZERO;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", folio='" + folio + '\'' +
                ", monto=" + monto +
                ", metodoPago=" + metodoPago +
                ", concepto='" + concepto + '\'' +
                ", fechaPago=" + fechaPago +
                ", estado='" + estado + '\'' +
                ", alumno=" + (alumno != null ? alumno.getMatricula() : "null") +
                ", periodoEscolar=" + (periodoEscolar != null ? periodoEscolar.getNombrePeriodo() : "null") +
                '}';
    }
}