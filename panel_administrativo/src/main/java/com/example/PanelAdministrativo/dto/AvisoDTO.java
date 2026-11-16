package com.example.PanelAdministrativo.dto;

import java.time.LocalDateTime;

/**
 * Comunicado visible para el alumno.
 */
public record AvisoDTO(
        Long id,
        String titulo,
        String contenido,
        String prioridad,
        LocalDateTime fechaCreacion
) {
}
