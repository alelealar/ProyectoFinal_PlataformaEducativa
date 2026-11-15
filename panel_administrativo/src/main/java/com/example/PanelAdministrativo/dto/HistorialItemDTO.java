package com.example.PanelAdministrativo.dto;

import com.example.PanelAdministrativo.model.EstadoInscripcion;

/**
 * Materia cursada en un periodo ya archivado, con su calificación final.
 */
public record HistorialItemDTO(
        String periodo,
        String materiaClave,
        String materiaNombre,
        int creditos,
        float calificacion,
        EstadoInscripcion estado
) {
}
