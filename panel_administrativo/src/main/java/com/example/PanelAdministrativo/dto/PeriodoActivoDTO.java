package com.example.PanelAdministrativo.dto;

import java.time.LocalDate;

/**
 * Periodo escolar activo con su avance, para el encabezado del storefront.
 */
public record PeriodoActivoDTO(
        Long id,
        String nombrePeriodo,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        int semanaActual,
        int totalSemanas,
        int porcentajeAvance
) {
}
