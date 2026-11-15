package com.example.PanelAdministrativo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Datos para cambiar la contraseña del alumno autenticado.
 */
public record CambiarContrasenaDTO(
        @NotBlank(message = "La contraseña actual es obligatoria.")
        String contraseñaActual,

        @NotBlank(message = "La nueva contraseña es obligatoria.")
        @Size(min = 8, max = 72, message = "La nueva contraseña debe tener entre 8 y 72 caracteres.")
        String contraseñaNueva
) {
}
