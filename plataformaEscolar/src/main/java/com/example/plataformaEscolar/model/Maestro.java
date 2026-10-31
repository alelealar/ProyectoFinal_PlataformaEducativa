package com.example.plataformaEscolar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un docente de la plataforma escolar.
 * Hereda de Usuario para compartir la información personal y de acceso,
 * agregando los atributos específicos del ámbito laboral/académico.
 *
 * @author Equipo 2 - Amarillo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Maestro extends Usuario {

    /**
     * Número de empleado asignado al maestro.
     */
    @Min(value = 1)
    @Max(value = 100)
    @NotBlank(message = "El numero de empleado no puede estar vacío")
    private String numEmpleado;


    @OneToMany(mappedBy = "maestro")
    private List<Clase> clases;


}