package com.example.PanelAdministrativo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Credenciales que envía el alumno desde el storefront.
 */
public record LoginAlumnoDTO(
        @NotBlank(message = "La matrícula es obligatoria.")
        @Pattern(regexp = "^\\d{10}$", message = "La matrícula debe tener 10 dígitos.")
        String matricula,

        @NotBlank(message = "La contraseña es obligatoria.")
        String contraseña
) {
}
