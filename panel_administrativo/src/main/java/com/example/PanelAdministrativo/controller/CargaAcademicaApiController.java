package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.dto.ClaseCatalogoDTO;
import com.example.PanelAdministrativo.dto.HistorialItemDTO;
import com.example.PanelAdministrativo.dto.InscripcionAlumnoDTO;
import com.example.PanelAdministrativo.dto.InscripcionRequestDTO;
import com.example.PanelAdministrativo.service.CargaAcademicaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CargaAcademicaApiController {

    private final CargaAcademicaService cargaAcademicaService;

    public CargaAcademicaApiController(CargaAcademicaService cargaAcademicaService) {
        this.cargaAcademicaService = cargaAcademicaService;
    }

    @GetMapping("/clases")
    public List<ClaseCatalogoDTO> catalogo() {
        return cargaAcademicaService.obtenerCatalogoActivo();
    }

    @GetMapping("/alumnos/me/inscripciones")
    public List<InscripcionAlumnoDTO> inscripciones(@AuthenticationPrincipal Long alumnoId) {
        return cargaAcademicaService.obtenerInscripcionesActivas(alumnoId);
    }

    @GetMapping("/alumnos/me/historial")
    public List<HistorialItemDTO> historial(@AuthenticationPrincipal Long alumnoId) {
        return cargaAcademicaService.obtenerHistorial(alumnoId);
    }

    @PostMapping("/alumnos/me/inscripciones")
    @ResponseStatus(HttpStatus.CREATED)
    public List<InscripcionAlumnoDTO> inscribir(@AuthenticationPrincipal Long alumnoId,
                                                @Valid @RequestBody InscripcionRequestDTO request) {
        return cargaAcademicaService.inscribirClases(alumnoId, request.getClaseIDs());
    }

    @DeleteMapping("/alumnos/me/inscripciones/{inscripcionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void darDeBaja(@AuthenticationPrincipal Long alumnoId,
                          @PathVariable Long inscripcionId) {
        cargaAcademicaService.darDeBajaInscripcion(alumnoId, inscripcionId);
    }
}
