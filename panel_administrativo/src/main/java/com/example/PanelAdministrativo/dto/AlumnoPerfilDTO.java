package com.example.PanelAdministrativo.dto;

/**
 * Datos del alumno autenticado que muestra el storefront. No incluye la contraseña.
 */
public record AlumnoPerfilDTO(
        Long id,
        String matricula,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String correo,
        String correoInstitucional,
        String telefono,
        String carrera
) {
}
