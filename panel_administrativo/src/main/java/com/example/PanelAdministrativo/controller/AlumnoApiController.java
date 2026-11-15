package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.dto.AlumnoPerfilDTO;
import com.example.PanelAdministrativo.dto.CambiarContrasenaDTO;
import com.example.PanelAdministrativo.exception.WrongPasswordException;
import com.example.PanelAdministrativo.model.Alumno;
import com.example.PanelAdministrativo.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/alumnos/me")
public class AlumnoApiController {

    private final AlumnoService alumnoService;

    public AlumnoApiController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public AlumnoPerfilDTO perfil(@AuthenticationPrincipal Long alumnoId) {
        Alumno alumno = alumnoService.buscarAlumnoPorId(alumnoId);
        if (alumno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró al alumno.");
        }
        return new AlumnoPerfilDTO(
                alumno.getId(),
                alumno.getMatricula(),
                alumno.getNombre(),
                alumno.getApellidoPaterno(),
                alumno.getApellidoMaterno(),
                alumno.getCorreo(),
                alumno.getCorreoInstitucional(),
                alumno.getTelefono(),
                alumno.getCarrera() == null ? null : alumno.getCarrera().getNombre());
    }

    @PutMapping("/contrasena")
    public ResponseEntity<Void> cambiarContrasena(@AuthenticationPrincipal Long alumnoId,
                                                  @Valid @RequestBody CambiarContrasenaDTO solicitud) {
        try {
            alumnoService.cambiarContraseña(alumnoId,
                    solicitud.contraseñaActual(), solicitud.contraseñaNueva());
        } catch (WrongPasswordException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
