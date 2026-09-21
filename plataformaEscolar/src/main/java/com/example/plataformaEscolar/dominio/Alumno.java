package com.example.plataformaEscolar.dominio;

import java.util.List;

/**
 * Representa a un alumno de la plataforma escolar.
 * Guarda su información personal, escolar
 * y sus horarios.
 *
 * @author Equipo 2 - Amarillo
 */
public class Alumno {

    /**
     * Nombre del alumno.
     */
    private String nombre;

    /**
     * Apellido paterno del alumno.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del alumno.
     */
    private String apellidoMaterno;

    /**
     * Correo personal del alumno.
     */
    private String correo;

    /**
     * Correo institucional del alumno.
     */
    private String correoInstitucional;

    /**
     * Matrícula del alumno.
     */
    private String matricula;

    /**
     * Contraseña del alumno.
     */
    private String contrasenia;

    /**
     * Período escolar del alumno.
     */
    private PeriodoEscolar periodoEscolar;

    /**
     * Horarios del alumno.
     */
    private List<HorarioAlumno> horarios;

    /**
     * Crea un alumno vacío.
     */
    public Alumno() {
    }

    /**
     * Crea un alumno con todos sus datos.
     *
     * @param nombre nombre del alumno
     * @param apellidoPaterno apellido paterno del alumno
     * @param apellidoMaterno apellido materno del alumno
     * @param correo correo personal del alumno
     * @param correoInstitucional correo institucional del alumno
     * @param matricula matrícula del alumno
     * @param contrasenia contraseña del alumno
     * @param periodoEscolar período escolar del alumno
     * @param horarios horarios del alumno
     */
    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno,
                  String correo, String correoInstitucional, String matricula,
                  String contrasenia, PeriodoEscolar periodoEscolar,
                  List<HorarioAlumno> horarios) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.correoInstitucional = correoInstitucional;
        this.matricula = matricula;
        this.contrasenia = contrasenia;
        this.periodoEscolar = periodoEscolar;
        this.horarios = horarios;
    }

    /**
     * Regresa el nombre del alumno.
     *
     * @return nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del alumno.
     *
     * @param nombre nuevo nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido paterno.
     *
     * @return apellido paterno del alumno
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
     * @return apellido materno del alumno
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
     * @return correo del alumno
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cambia el correo personal.
     *
     * @param correo nuevo correo del alumno
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Regresa el correo institucional.
     *
     * @return correo institucional del alumno
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
     * Regresa la matrícula.
     *
     * @return matrícula del alumno
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Cambia la matrícula.
     *
     * @param matricula nueva matrícula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Regresa la contraseña.
     *
     * @return contraseña del alumno
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Cambia la contraseña.
     *
     * @param contrasenia nueva contraseña
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Regresa el período escolar.
     *
     * @return período escolar del alumno
     */
    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    /**
     * Cambia el período escolar.
     *
     * @param periodoEscolar nuevo período escolar
     */
    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    /**
     * Regresa los horarios del alumno.
     *
     * @return lista de horarios
     */
    public List<HorarioAlumno> getHorarios() {
        return horarios;
    }

    /**
     * Cambia los horarios del alumno.
     *
     * @param horarios nueva lista de horarios
     */
    public void setHorarios(List<HorarioAlumno> horarios) {
        this.horarios = horarios;
    }

    /**
     * Regresa la información del alumno.
     *
     * @return datos del alumno en texto
     */
    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", matricula='" + matricula + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", periodoEscolar=" + periodoEscolar +
                ", horarios=" + horarios +
                '}';
    }
}