package com.example.plataformaEscolar.dominio;


/**
 * Representa un maestro dentro de la plataforma escolar.
 * Contiene la información personal y de identificación como empleado.
 *
 * @author Equipo 2 - Amarillo
 */
public class Maestro {

    /** Nombre del maestro. */
    private String nombre;

    /** Apellido paterno del maestro. */
    private String apellidoPaterno;

    /** Apellido materno del maestro. */
    private String apellidoMaterno;

    /** Correo electrónico del maestro. */
    private String correo;

    private String correoInstitucional;

    /** Matrícula de registro del maestro. */
    private String matricula;

    /** Número de empleado del maestro en la institución. */
    private String numeroEmpleado;

    private String contrasena;

    /**
     * Crea un maestro sin datos iniciales.
     */
    public Maestro() {
    }

    /**
     * Crea un maestro con todos sus datos.
     *
     * @param nombre nombre del maestro
     * @param apellidoPaterno apellido paterno del maestro
     * @param apellidoMaterno apellido materno del maestro
     * @param correo correo electrónico del maestro
     * @param matricula matrícula del maestro
     * @param numeroEmpleado número de empleado
     */
    public Maestro(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String matricula, String numeroEmpleado, String correoInstitucional, String contrasena) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.matricula = matricula;
        this.numeroEmpleado = numeroEmpleado;
        this.correoInstitucional = correoInstitucional;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del maestro.
     *
     * @return nombre del maestro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del maestro.
     *
     * @param nombre nuevo nombre del maestro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del maestro.
     *
     * @return apellido paterno del maestro
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del maestro.
     *
     * @param apellidoPaterno nuevo apellido paterno del maestro
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del maestro.
     *
     * @return apellido materno del maestro
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del maestro.
     *
     * @param apellidoMaterno nuevo apellido materno del maestro
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del maestro.
     *
     * @return correo del maestro
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del maestro.
     *
     * @param correo nuevo correo del maestro
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la matrícula del maestro.
     *
     * @return matrícula del maestro
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del maestro.
     *
     * @param matricula nueva matrícula del maestro
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el número de empleado del maestro.
     *
     * @return número de empleado
     */
    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    /**
     * Establece el número de empleado del maestro.
     *
     * @param numeroEmpleado nuevo número de empleado
     */
    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Devuelve una representación en texto del maestro.
     *
     * @return representación en texto del maestro
     */
    @Override
    public String toString() {
        return "Maestro{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", matricula='" + matricula + '\'' +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}