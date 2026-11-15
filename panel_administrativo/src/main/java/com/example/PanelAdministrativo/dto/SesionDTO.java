package com.example.PanelAdministrativo.dto;

/**
 * Respuesta del login: token de acceso y datos básicos del alumno.
 */
public record SesionDTO(
        String token,
        String tipo,
        long expiraEnSegundos,
        Long alumnoId,
        String nombre
) {
}
