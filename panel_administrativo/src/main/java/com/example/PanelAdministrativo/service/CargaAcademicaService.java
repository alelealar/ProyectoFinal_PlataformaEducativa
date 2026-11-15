package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.dto.ClaseCatalogoDTO;
import com.example.PanelAdministrativo.dto.HistorialItemDTO;
import com.example.PanelAdministrativo.dto.HorarioDTO;
import com.example.PanelAdministrativo.dto.InscripcionAlumnoDTO;
import com.example.PanelAdministrativo.model.Clase;
import com.example.PanelAdministrativo.model.EstadoInscripcion;
import com.example.PanelAdministrativo.model.Inscripcion;
import com.example.PanelAdministrativo.model.Maestro;
import com.example.PanelAdministrativo.model.Materia;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.InscripcionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Consultas de carga académica para el storefront: catálogo del periodo, inscripciones
 * activas del alumno e historial de periodos archivados.
 */
@Service
public class CargaAcademicaService {

    private final ClaseRepository claseRepository;
    private final InscripcionRepository inscripcionRepository;
    private final MateriaService materiaService;

    public CargaAcademicaService(ClaseRepository claseRepository,
                                 InscripcionRepository inscripcionRepository,
                                 MateriaService materiaService) {
        this.claseRepository = claseRepository;
        this.inscripcionRepository = inscripcionRepository;
        this.materiaService = materiaService;
    }

    @Transactional(readOnly = true)
    public List<ClaseCatalogoDTO> obtenerCatalogoActivo() {
        return materiaService.obtenerPeriodoActivo()
                .map(periodo -> claseRepository.findByPeriodoEscolar_Id(periodo.getId()).stream()
                        .map(this::aCatalogo)
                        .toList())
                .orElse(List.of());
    }

    @Transactional(readOnly = true)
    public List<InscripcionAlumnoDTO> obtenerInscripcionesActivas(Long alumnoId) {
        return materiaService.obtenerPeriodoActivo()
                .map(periodo -> inscripcionRepository
                        .findActivasDelPeriodo(alumnoId, periodo.getId(), EstadoInscripcion.BAJA).stream()
                        .map(this::aInscripcion)
                        .toList())
                .orElse(List.of());
    }

    @Transactional(readOnly = true)
    public List<HistorialItemDTO> obtenerHistorial(Long alumnoId) {
        return inscripcionRepository.findHistorialArchivado(alumnoId, EstadoInscripcion.BAJA).stream()
                .map(this::aHistorial)
                .toList();
    }

    private InscripcionAlumnoDTO aInscripcion(Inscripcion inscripcion) {
        return new InscripcionAlumnoDTO(
                inscripcion.getId(),
                inscripcion.getEstado(),
                inscripcion.getFechaInscripcion(),
                aCatalogo(inscripcion.getClase()));
    }

    private HistorialItemDTO aHistorial(Inscripcion inscripcion) {
        Clase clase = inscripcion.getClase();
        Materia materia = clase.getMateria();
        return new HistorialItemDTO(
                clase.getPeriodoEscolar().getNombrePeriodo(),
                materia == null ? null : materia.getClave(),
                materia == null ? null : materia.getNombre(),
                materia == null ? 0 : materia.getCreditos(),
                inscripcion.getCalificacion(),
                inscripcion.getEstado());
    }

    private ClaseCatalogoDTO aCatalogo(Clase clase) {
        Materia materia = clase.getMateria();
        Maestro maestro = clase.getMaestro();
        String docente = maestro == null ? null : maestro.getNombre() + " " + maestro.getApellidoPaterno();
        List<HorarioDTO> horarios = clase.getHorarios().stream()
                .map(h -> new HorarioDTO(h.getDias(), h.getHoraEntrada(), h.getHoraSalida(), h.getAula()))
                .toList();

        return new ClaseCatalogoDTO(
                clase.getId(),
                clase.getClave(),
                clase.getNombre(),
                materia == null ? null : materia.getClave(),
                materia == null ? null : materia.getNombre(),
                materia == null ? 0 : materia.getCreditos(),
                docente,
                clase.getCupoMaximo(),
                clase.getCupoDisponible(),
                horarios);
    }
}
