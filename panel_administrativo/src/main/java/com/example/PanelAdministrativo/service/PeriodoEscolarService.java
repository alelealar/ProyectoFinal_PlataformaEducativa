package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.dto.ResumenPeriodoDTO;
import com.example.PanelAdministrativo.model.Clase;
import com.example.PanelAdministrativo.model.EstadoInscripcion;
import com.example.PanelAdministrativo.model.PeriodoEscolar;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.PeriodoEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@Service
public class PeriodoEscolarService {

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private AlumnoService alumnoService;

    /**
     * Calcula los datos mostrados en la vista de periodos escolares para el periodo indicado.
     *
     * @param periodo periodo activo; si es nulo se regresan todos los valores en cero
     * @return resumen con matriculados, avance del ciclo, aforo, docentes y periodos archivados
     */
    @Transactional(readOnly = true)
    public ResumenPeriodoDTO construirResumen(PeriodoEscolar periodo) {
        ResumenPeriodoDTO resumen = new ResumenPeriodoDTO();
        if (periodo == null) {
            return resumen;
        }

        List<Clase> clases = claseRepository.findByPeriodoEscolar_Id(periodo.getId());

        long capacidad = 0;
        long ocupados = 0;
        for (Clase clase : clases) {
            capacidad += clase.getCupoMaximo();
            if (clase.getInscripciones() != null) {
                ocupados += clase.getInscripciones().stream()
                        .filter(inscripcion -> inscripcion.getEstado() != EstadoInscripcion.BAJA)
                        .count();
            }
        }

        resumen.setMatriculados(alumnoService.contarMatriculadosActivos(periodo.getId()));
        resumen.setPorcentajeAforo(capacidad > 0 ? (int) Math.round(ocupados * 100.0 / capacidad) : 0);
        resumen.setDocentesAsignados(clases.stream()
                .map(Clase::getMaestro)
                .filter(Objects::nonNull)
                .map(maestro -> maestro.getId())
                .distinct()
                .count());

        if (periodo.getFechaInicio() != null && periodo.getFechaFin() != null) {
            long dias = ChronoUnit.DAYS.between(periodo.getFechaInicio(), periodo.getFechaFin());
            int totalSemanas = (int) Math.max(1, Math.ceil((dias + 1) / 7.0));
            LocalDate hoy = LocalDate.now();
            int semanaActual;
            if (hoy.isBefore(periodo.getFechaInicio())) {
                semanaActual = 0;
            } else {
                semanaActual = (int) Math.min(totalSemanas,
                        ChronoUnit.DAYS.between(periodo.getFechaInicio(), hoy) / 7 + 1);
            }
            resumen.setTotalSemanas(totalSemanas);
            resumen.setSemanaActual(semanaActual);
            resumen.setPorcentajeAvance((int) Math.round(semanaActual * 100.0 / totalSemanas));
        }

        resumen.setPeriodosArchivados(periodoEscolarRepository.countByActivoFalse());

        return resumen;
    }

}
