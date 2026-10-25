package com.example.plataformaEscolar.model;

/**
 * Representa la entidad base de usuario dentro de la plataforma escolar.
 * Contiene la información personal y las credenciales de acceso compartidas por Alumnos y Maestros.
 *
 * @author Equipo 2 - Amarillo
 */
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    private Integer id;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Apellido paterno del usuario.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del usuario.
     */
    private String apellidoMaterno;

    /**
     * Correo electrónico personal.
     */
    private String correo;

    /**
     * Número telefónico de contacto.
     */
    private String telefono;

    /**
     * Contraseña de acceso al sistema.
     */
    private String contraseña;

    /**
     * Rol asignado dentro del sistema (ej. "ALUMNO", "MAESTRO", "ADMIN").
     */
    private String rol;

    /**
     * Crea un usuario vacío.
     */
    public Usuario() {
    }

    /**
     * Crea un usuario con todos sus datos personales y de acceso.
     *
     * @param id identificador único
     * @param nombre nombre del usuario
     * @param apellidoPaterno apellido paterno
     * @param apellidoMaterno apellido materno
     * @param correo correo personal
     * @param telefono teléfono de contacto
     * @param contraseña contraseña de acceso
     * @param rol rol dentro del sistema
     */
    public Usuario(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String correo, String telefono, String contraseña, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    /**
     * Regresa el identificador del usuario.
     *
     * @return id del usuario
     */
    public Integer getId() {
        return id;
    }

    /**
     * Cambia el identificador del usuario.
     *
     * @param id nuevo identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa el nombre del usuario.
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del usuario.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido paterno.
     *
     * @return apellido paterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Cambia el apellido paterno.
     *
     * @param apellidoPaterno nuevo apellido paterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Regresa el apellido materno.
     *
     * @return apellido materno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Cambia el apellido materno.
     *
     * @param apellidoMaterno nuevo apellido materno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Regresa el correo personal.
     *
     * @return correo personal
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cambia el correo personal.
     *
     * @param correo nuevo correo personal
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Regresa el teléfono de contacto.
     *
     * @return teléfono de contacto
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Cambia el teléfono de contacto.
     *
     * @param telefono nuevo teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Regresa la contraseña del usuario.
     *
     * @return contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Cambia la contraseña del usuario.
     *
     * @param contraseña nueva contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Regresa el rol del usuario.
     *
     * @return rol asignado
     */
    public String getRol() {
        return rol;
    }

    /**
     * Cambia el rol del usuario.
     *
     * @param rol nuevo rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Regresa la información del usuario en texto.
     *
     * @return representación en cadena de los datos del usuario
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}