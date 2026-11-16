package com.example.PanelAdministrativo.dto;

import java.util.List;

/**
 * Grupo ofertado en el periodo activo. Incluye cupos agregados, nunca los alumnos inscritos.
 */
public record ClaseCatalogoDTO(
        Long id,
        String clave,
        String nombre,
        String materiaClave,
        String materiaNombre,
        int creditos,
        String docente,
        int cupoMaximo,
        int cupoDisponible,
        List<HorarioDTO> horarios
) {
}
