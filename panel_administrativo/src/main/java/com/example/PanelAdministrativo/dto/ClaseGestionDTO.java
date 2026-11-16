package com.example.PanelAdministrativo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaseGestionDTO {
    private Long claseId;
    private Long materiaId;
    private String materiaClave;
    private String materiaNombre;
    private String nrc;
    private Long docenteId;
    private String docente;
    private String carrera;
    private int ocupados;
    private int cupoMaximo;
    private int cuposDisponibles;
    private double porcentajeOcupacion;

    public double getPorcentajeBarra() {
        return Math.min(porcentajeOcupacion, 100.0);
    }
}
