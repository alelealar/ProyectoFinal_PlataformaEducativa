package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.dto.PeriodoActivoDTO;
import com.example.PanelAdministrativo.dto.ResumenPeriodoDTO;
import com.example.PanelAdministrativo.model.PeriodoEscolar;
import com.example.PanelAdministrativo.service.MateriaService;
import com.example.PanelAdministrativo.service.PeriodoEscolarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/periodos")
public class PeriodoApiController {

    private final MateriaService materiaService;
    private final PeriodoEscolarService periodoEscolarService;

    public PeriodoApiController(MateriaService materiaService, PeriodoEscolarService periodoEscolarService) {
        this.materiaService = materiaService;
        this.periodoEscolarService = periodoEscolarService;
    }

    @GetMapping("/activo")
    public PeriodoActivoDTO periodoActivo() {
        PeriodoEscolar periodo = materiaService.obtenerPeriodoActivo()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No hay un periodo escolar activo."));

        ResumenPeriodoDTO resumen = periodoEscolarService.construirResumen(periodo);

        return new PeriodoActivoDTO(
                periodo.getId(),
                periodo.getNombrePeriodo(),
                periodo.getFechaInicio(),
                periodo.getFechaFin(),
                resumen.getSemanaActual(),
                resumen.getTotalSemanas(),
                resumen.getPorcentajeAvance());
    }
}
