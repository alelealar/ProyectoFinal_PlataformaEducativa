package com.example.plataformaEscolar.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase base para la gestión de usuarios del sistema.
 *
 * @author Equipo 2 - Amarillo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellidoPaterno;

    private String apellidoMaterno;

    @Email(message = "El correo debe de tener un formato válido")
    @NotBlank(message = "El correo no puede estar vacio")
    private String correo;

    @Email(message = "El correo debe de tener un formato válido")
    private String correoInstitucional;

    @NotBlank(message = "La contraseña no puede estar vacia")
    private String contraseña;

    @Pattern(regexp = "^\\\\d{10}$", message = "Formato de teléfono no válido")
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Rol rol; // Implementación de EnumRol

}