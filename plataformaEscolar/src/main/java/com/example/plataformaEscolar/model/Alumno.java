package com.example.plataformaEscolar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un alumno dentro de la plataforma escolar.
 * Hereda la información personal y credenciales de acceso de Usuario.
 *
 * @author Equipo 2 - Amarillo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "alumnos")
public class Alumno extends Usuario {

    /**
     * Matrícula única del alumno.
     */
    @NotBlank(message = "La matricula no puede ser nula")
    private String matricula;


    /**
     * Carrera universitaria a la que pertenece el alumno.
     */
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @OneToMany(mappedBy = "alumno")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "alumno")
    private List<Inscripcion> inscripciones;

}