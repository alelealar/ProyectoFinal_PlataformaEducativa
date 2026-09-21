package com.example.plataformaEscolar.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un maestro de la plataforma escolar.
 * Contiene su información personal, de contacto
 * y sus horarios.
 *
 * @author Equipo 2 - Amarillo
 */
public class Maestro {

    /**
     * Nombre del maestro.
     */
    private String nombre;

    /**
     * Apellido paterno del maestro.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del maestro.
     */
    private String apellidoMaterno;

    /**
     * Correo personal del maestro.
     */
    private String correo;

    /**
     * Correo institucional del maestro.
     */
    private String correoInstitucional;

    /**
     * Matrícula del maestro.
     */
    private String matricula;

    /**
     * Contraseña del maestro.
     */
    private String contrasena;

    /**
     * Horarios asignados al maestro.
     */
    private List<HorarioMaestro> horariosMaestro;

    /**
     * Crea un maestro vacío.
     */
    public Maestro() {
        this.horariosMaestro = new ArrayList<>();
    }

    /**
     * Crea un maestro con todos sus datos.
     *
     * @param nombre nombre del maestro
     * @param apellidoPaterno apellido paterno del maestro
     * @param apellidoMaterno apellido materno del maestro
     * @param correo correo personal del maestro
     * @param correoInstitucional correo institucional del maestro
     * @param matricula matrícula del maestro
     * @param contrasena contraseña del maestro
     * @param horariosMaestro horarios del maestro
     */
    public Maestro(String nombre, String apellidoPaterno,
                   String apellidoMaterno, String correo,
                   String correoInstitucional, String matricula,
                   String contrasena,
                   List<HorarioMaestro> horariosMaestro) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.correoInstitucional = correoInstitucional;
        this.matricula = matricula;
        this.contrasena = contrasena;
        this.horariosMaestro = horariosMaestro;
    }

    /**
     * Regresa el nombre del maestro.
     *
     * @return nombre del maestro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del maestro.
     *
     * @param nombre nuevo nombre del maestro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido paterno.
     *
     * @return apellido paterno del maestro
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
     * @return apellido materno del maestro
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
     * @return correo personal del maestro
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
     * Regresa el correo institucional.
     *
     * @return correo institucional del maestro
     */
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    /**
     * Cambia el correo institucional.
     *
     * @param correoInstitucional nuevo correo institucional
     */
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * Regresa la matrícula del maestro.
     *
     * @return matrícula del maestro
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
     * Regresa la contraseña.
     *
     * @return contraseña del maestro
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
     * Regresa los horarios del maestro.
     *
     * @return lista de horarios
     */
    public List<HorarioMaestro> getHorariosMaestro() {
        return horariosMaestro;
    }

    /**
     * Cambia los horarios del maestro.
     *
     * @param horariosMaestro nueva lista de horarios
     */
    public void setHorariosMaestro(List<HorarioMaestro> horariosMaestro) {
        this.horariosMaestro = horariosMaestro;
    }

    /**
     * Regresa la información del maestro.
     *
     * @return datos del maestro en texto
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
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}