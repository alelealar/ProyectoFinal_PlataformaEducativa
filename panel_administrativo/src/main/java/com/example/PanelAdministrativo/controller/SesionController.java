package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.dto.LoginAlumnoDTO;
import com.example.PanelAdministrativo.dto.SesionDTO;
import com.example.PanelAdministrativo.model.Alumno;
import com.example.PanelAdministrativo.service.AlumnoService;
import com.example.PanelAdministrativo.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    private final AlumnoService alumnoService;
    private final JwtService jwtService;

    public SesionController(AlumnoService alumnoService, JwtService jwtService) {
        this.alumnoService = alumnoService;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<SesionDTO> iniciarSesion(@Valid @RequestBody LoginAlumnoDTO solicitud) {
        Alumno alumno = alumnoService.autenticarAlumno(solicitud.matricula(), solicitud.contraseña())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Matrícula o contraseña incorrectas."));

        SesionDTO sesion = new SesionDTO(
                jwtService.generarTokenAlumno(alumno),
                "Bearer",
                jwtService.getExpiracionSegundos(),
                alumno.getId(),
                alumno.getNombre());

        return ResponseEntity.ok(sesion);
    }
}
