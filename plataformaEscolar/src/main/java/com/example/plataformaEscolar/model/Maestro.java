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
     * Número de empleado o matrícula única del maestro.
     */
    private String matricula;

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
     * @param matricula número de empleado o matrícula
     * @param correoInstitucional correo institucional del maestro
     */
    public Maestro(String matricula, String correoInstitucional) {
        this.matricula = matricula;
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * Crea un maestro con todos los datos personales e institucionales completos.
     *
     * @param id identificador único del usuario
     * @param nombre nombre del maestro
     * @param apellidoPaterno apellido paterno del maestro
     * @param apellidoMaterno apellido materno del maestro
     * @param correo correo personal del maestro
     * @param telefono teléfono de contacto del maestro
     * @param contraseña contraseña de acceso
     * @param rol rol dentro del sistema
     * @param matricula matrícula o número de empleado
     * @param correoInstitucional correo institucional del maestro
     */
    public Maestro(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String correo, String telefono, String contraseña, String rol,
                   String matricula, String correoInstitucional) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, contraseña, rol);
        this.matricula = matricula;
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * Regresa la matrícula del maestro.
     *
     * @return matrícula o número de empleado
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Cambia la matrícula del maestro.
     *
     * @param matricula nueva matrícula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Regresa el correo institucional del maestro.
     *
     * @return correo institucional
     */
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    /**
     * Cambia el correo institucional del maestro.
     *
     * @param correoInstitucional nuevo correo institucional
     */
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * Regresa la información del maestro en formato texto.
     *
     * @return representación en cadena de los datos del maestro
     */
    @Override
    public String toString() {
        return "Maestro{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellidoPaterno='" + getApellidoPaterno() + '\'' +
                ", apellidoMaterno='" + getApellidoMaterno() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}