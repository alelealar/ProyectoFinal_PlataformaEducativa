package com.example.plataformaEscolar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

/**
 * Representa a un alumno dentro de la plataforma escolar.
 * Hereda la información personal y credenciales de acceso de Usuario.
 *
 * @author Equipo 2 - Amarillo
 */
@Entity
public class Alumno extends Usuario {

    /**
     * Matrícula única del alumno.
     */
    @Min(value = 1)
    @Max(value = 100)
    private String matricula;

    /**
     * Correo institucional asignado al alumno.
     */
    @Email(message = "El correo debe de tener un formato válido")
    private String correoInstitucional;

    /**
     * Carrera universitaria a la que pertenece el alumno.
     */
    @Enumerated(EnumType.STRING)
    private Carrera carrera;

    /**
     * Crea un alumno vacío.
     */
    public Alumno() {
        super();
    }

    /**
     * Crea un alumno con sus atributos propios.
     *
     * @param matricula matrícula única del alumno
     * @param correoInstitucional correo institucional asignado
     * @param carrera carrera a la que pertenece
     */
    public Alumno(String matricula, String correoInstitucional, Carrera carrera) {
        this.matricula = matricula;
        this.correoInstitucional = correoInstitucional;
        this.carrera = carrera;
    }

    /**
     * Crea un alumno con todos los datos personales e institucionales completos.
     *
     * @param id identificador único del usuario (Long)
     * @param nombre nombre del alumno
     * @param apellidoPaterno apellido paterno del alumno
     * @param apellidoMaterno apellido materno del alumno
     * @param correo correo personal del alumno
     * @param telefono teléfono de contacto
     * @param contrasenia contraseña de acceso
     * @param rol rol dentro del sistema (Enum Rol)
     * @param matricula matrícula única del alumno
     * @param correoInstitucional correo institucional asignado
     * @param carrera carrera a la que pertenece
     */
    public Alumno(Long id, String nombre, String apellidoPaterno, String apellidoMaterno,
                  String correo, String telefono, String contrasenia, Rol rol,
                  String matricula, String correoInstitucional, Carrera carrera) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, contrasenia, rol);
        this.matricula = matricula;
        this.correoInstitucional = correoInstitucional;
        this.carrera = carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellidoPaterno='" + getApellidoPaterno() + '\'' +
                ", apellidoMaterno='" + getApellidoMaterno() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", matricula='" + matricula + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", carrera=" + (carrera != null ? carrera.getNombre() : "null") +
                '}';
    }
}