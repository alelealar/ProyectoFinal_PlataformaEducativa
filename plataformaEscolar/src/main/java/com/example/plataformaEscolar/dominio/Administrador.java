package com.example.plataformaEscolar.dominio;

/**
 * Representa a un administrador dentro de la plataforma escolar.
 * El administrador se encarga de gestionar información dentro del sistema.
 *
 * @author Equipo 2 - Amarillo
 */
public class Administrador {

    /** Nombre del administrador. */
    private String nombre;

    /** Apellido paterno del administrador. */
    private String apellidoPaterno;

    /** Apellido materno del administrador. */
    private String apellidoMaterno;

    /** Correo electrónico del administrador. */
    private String correo;

    /** Nombre de usuario del administrador. */
    private String usuario;

    /** Contraseña del administrador. */
    private String contrasena;

    /**
     * Crea un administrador sin datos iniciales.
     */
    public Administrador() {
    }

    /**
     * Crea un administrador con todos sus datos.
     *
     * @param nombre nombre del administrador
     * @param apellidoPaterno apellido paterno del administrador
     * @param apellidoMaterno apellido materno del administrador
     * @param correo correo electrónico del administrador
     * @param usuario nombre de usuario del administrador
     * @param contrasena contraseña del administrador
     */
    public Administrador(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del administrador.
     *
     * @return nombre del administrador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del administrador.
     *
     * @param nombre nuevo nombre del administrador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del administrador.
     *
     * @return apellido paterno del administrador
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del administrador.
     *
     * @param apellidoPaterno nuevo apellido paterno del administrador
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del administrador.
     *
     * @return apellido materno del administrador
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del administrador.
     *
     * @param apellidoMaterno nuevo apellido materno del administrador
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del administrador.
     *
     * @return correo electrónico del administrador
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del administrador.
     *
     * @param correo nuevo correo electrónico del administrador
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el nombre de usuario del administrador.
     *
     * @return nombre de usuario del administrador
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del administrador.
     *
     * @param usuario nuevo nombre de usuario del administrador
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del administrador.
     *
     * @return contraseña del administrador
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del administrador.
     *
     * @param contrasena nueva contraseña del administrador
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Devuelve una representación en texto del administrador.
     *
     * @return representación en texto del administrador
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
