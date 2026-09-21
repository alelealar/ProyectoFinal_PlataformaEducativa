package com.example.plataformaEscolar.dominio;

/**
 * Representa a un administrador de la plataforma escolar.
 * Contiene la información básica para identificarlo
 * e iniciar sesión.
 *
 * @author Equipo 2 - Amarillo
 */
public class Administrador {

    /**
     * Nombre del administrador.
     */
    private String nombre;

    /**
     * Apellido paterno del administrador.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del administrador.
     */
    private String apellidoMaterno;

    /**
     * Correo electrónico del administrador.
     */
    private String correo;

    /**
     * Nombre de usuario del administrador.
     */
    private String usuario;

    /**
     * Contraseña del administrador.
     */
    private String contrasena;

    /**
     * Crea un administrador vacío.
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
    public Administrador(String nombre, String apellidoPaterno,
                         String apellidoMaterno, String correo,
                         String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Regresa el nombre del administrador.
     *
     * @return nombre del administrador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del administrador.
     *
     * @param nombre nuevo nombre del administrador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido paterno.
     *
     * @return apellido paterno del administrador
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
     * @return apellido materno del administrador
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
     * Regresa el correo electrónico.
     *
     * @return correo del administrador
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cambia el correo electrónico.
     *
     * @param correo nuevo correo del administrador
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Regresa el nombre de usuario.
     *
     * @return nombre de usuario del administrador
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Cambia el nombre de usuario.
     *
     * @param usuario nuevo nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Regresa la contraseña.
     *
     * @return contraseña del administrador
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Cambia la contraseña.
     *
     * @param contrasena nueva contraseña
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Regresa la información del administrador.
     *
     * @return datos del administrador en texto
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