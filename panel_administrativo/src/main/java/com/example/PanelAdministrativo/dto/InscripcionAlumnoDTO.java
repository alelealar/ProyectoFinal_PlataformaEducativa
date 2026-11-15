package com.example.PanelAdministrativo.dto;

import com.example.PanelAdministrativo.model.EstadoInscripcion;

import java.time.LocalDateTime;

/**
 * Inscripción del alumno en el periodo activo, con los datos del grupo.
 */
public record InscripcionAlumnoDTO(
        Long id,
        EstadoInscripcion estado,
        LocalDateTime fechaInscripcion,
        ClaseCatalogoDTO clase
) {
}
