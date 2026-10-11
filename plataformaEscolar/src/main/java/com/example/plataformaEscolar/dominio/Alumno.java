package com.example.plataformaEscolar.dominio;

/**
 * Representa a un alumno dentro de la plataforma escolar.
 * Hereda la información personal y credenciales de acceso de Usuario.
 *
 * @author Equipo 2 - Amarillo
 */
public class Alumno extends Usuario {

    /**
     * Matrícula única del alumno.
     */
    private String matricula;

    /**
     * Correo institucional asignado al alumno.
     */
    private String correoInstitucional;

    /**
     * Carrera universitaria a la que pertenece el alumno.
     */
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
     * @param id identificador único del usuario
     * @param nombre nombre del alumno
     * @param apellidoPaterno apellido paterno del alumno
     * @param apellidoMaterno apellido materno del alumno
     * @param correo correo personal del alumno
     * @param telefono teléfono de contacto
     * @param contrasenia contraseña de acceso
     * @param rol rol dentro del sistema
     * @param matricula matrícula única del alumno
     * @param correoInstitucional correo institucional asignado
     * @param carrera carrera a la que pertenece
     */
    public Alumno(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno,
                  String correo, String telefono, String contrasenia, String rol,
                  String matricula, String correoInstitucional, Carrera carrera) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, contrasenia, rol);
        this.matricula = matricula;
        this.correoInstitucional = correoInstitucional;
        this.carrera = carrera;
    }

    /**
     * Regresa la matrícula del alumno.
     *
     * @return matrícula única
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Cambia la matrícula del alumno.
     *
     * @param matricula nueva matrícula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Regresa el correo institucional del alumno.
     *
     * @return correo institucional
     */
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    /**
     * Cambia el correo institucional del alumno.
     *
     * @param correoInstitucional nuevo correo institucional
     */
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * Regresa la carrera a la que pertenece el alumno.
     *
     * @return carrera universitaria
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * Cambia la carrera a la que pertenece el alumno.
     *
     * @param carrera nueva carrera
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * Regresa la información del alumno en formato texto.
     *
     * @return representación en cadena de los datos del alumno
     */
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