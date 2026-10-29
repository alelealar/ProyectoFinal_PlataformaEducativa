package com.example.plataformaEscolar.model;

/**
 * Representa a un docente de la plataforma escolar.
 * Hereda de Usuario para compartir la información personal y de acceso,
 * agregando los atributos específicos del ámbito laboral/académico.
 *
 * @author Equipo 2 - Amarillo
 */
public class Maestro extends Usuario {

    /**
     * Número de empleado asignado al maestro.
     */
    private String numEmpleado;

    /**
     * Correo institucional asignado al maestro.
     */
    private String correoInstitucional;

    /**
     * Crea un maestro vacío.
     */
    public Maestro() {
        super();
    }

    /**
     * Crea un maestro con sus atributos propios.
     *
     * @param numEmpleado número de empleado
     * @param correoInstitucional correo institucional del maestro
     */
    public Maestro(String numEmpleado, String correoInstitucional) {
        this.numEmpleado = numEmpleado;
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * Crea un maestro con todos los datos personales e institucionales completos.
     *
     * @param id identificador único del usuario (Long)
     * @param nombre nombre del maestro
     * @param apellidoPaterno apellido paterno del maestro
     * @param apellidoMaterno apellido materno del maestro
     * @param correo correo personal del maestro
     * @param telefono teléfono de contacto del maestro
     * @param contraseña contraseña de acceso
     * @param rol rol dentro del sistema (Enum Rol)
     * @param numEmpleado número de empleado
     * @param correoInstitucional correo institucional del maestro
     */
    public Maestro(Long id, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String correo, String telefono, String contraseña, Rol rol,
                   String numEmpleado, String correoInstitucional) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, contraseña, rol);
        this.numEmpleado = numEmpleado;
        this.correoInstitucional = correoInstitucional;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    @Override
    public String toString() {
        return "Maestro{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellidoPaterno='" + getApellidoPaterno() + '\'' +
                ", apellidoMaterno='" + getApellidoMaterno() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }
}