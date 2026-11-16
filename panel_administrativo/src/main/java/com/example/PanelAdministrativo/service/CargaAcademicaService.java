package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.dto.ClaseCatalogoDTO;
import com.example.PanelAdministrativo.dto.HistorialItemDTO;
import com.example.PanelAdministrativo.dto.HorarioDTO;
import com.example.PanelAdministrativo.dto.InscripcionAlumnoDTO;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.exception.ResourceNotFoundException;
import com.example.PanelAdministrativo.model.*;
import com.example.PanelAdministrativo.repository.AlumnoRepository;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.InscripcionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Consultas de carga académica para el storefront: catálogo del periodo, inscripciones
 * activas del alumno e historial de periodos archivados.
 */
@Service
public class CargaAcademicaService {

    private final ClaseRepository claseRepository;
    private final InscripcionRepository inscripcionRepository;
    private final MateriaService materiaService;
    private final AlumnoRepository alumnoRepository;

    public CargaAcademicaService(ClaseRepository claseRepository,
                                 InscripcionRepository inscripcionRepository,
                                 MateriaService materiaService, AlumnoRepository alumnoRepository) {
        this.claseRepository = claseRepository;
        this.inscripcionRepository = inscripcionRepository;
        this.materiaService = materiaService;
        this.alumnoRepository = alumnoRepository;
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

    @Transactional
    public List<InscripcionAlumnoDTO> inscribirClases(Long alumnoId, List<Long> claseIds) {
        //Verificar que exista un periodo activo
        Optional<PeriodoEscolar> periodoOpt = materiaService.obtenerPeriodoActivo();
        if (periodoOpt.isEmpty()) {
            throw new BusinessRuleException("No hay un periodo escolar activo.");
        }
        PeriodoEscolar periodoActivo = periodoOpt.get();

        // Busca el alumno
        Optional<Alumno> alumnoOpt = alumnoRepository.findById(alumnoId);
        if (alumnoOpt.isEmpty()) {
            throw new ResourceNotFoundException("Alumno no encontrado.");
        }
        Alumno alumno = alumnoOpt.get(); //alumno encontrado

        //busca las clases activas del periodo
        List<Inscripcion> activasActuales = inscripcionRepository.findActivasDelPeriodo(alumnoId, periodoActivo.getId(), EstadoInscripcion.BAJA);


        List<Long> clasesYaInscritas = new ArrayList<>();
        for (Inscripcion inscripcion : activasActuales) {
            clasesYaInscritas.add(inscripcion.getClase().getId());
        }

        //validar e inscribir las clases seleccionadas por el alumno
        List<Long> idsProcesados = new ArrayList<>();
        for (Long claseId : claseIds) {
            if (idsProcesados.contains(claseId)) {
                continue; // Evita duplicados si mandan el mismo ID dos veces
            }
            idsProcesados.add(claseId);

            Optional<Clase> claseOpt = claseRepository.findById(claseId);
            if (claseOpt.isEmpty()) {
                throw new ResourceNotFoundException("La clase con ID " + claseId + " no existe.");
            }
            Clase clase = claseOpt.get();

            if (!clase.getPeriodoEscolar().getId().equals(periodoActivo.getId())) {
                throw new BusinessRuleException("La clase " + clase.getClave() + " no pertenece al periodo activo.");
            }

            if (clasesYaInscritas.contains(clase.getId())) {
                throw new BusinessRuleException("Ya estás inscrito en la clase " + clase.getClave() + ".");
            }

            if (clase.getCupoDisponible() <= 0) {
                throw new BusinessRuleException("La clase " + clase.getClave() + " ya no tiene cupo disponible.");
            }

            Inscripcion nueva = new Inscripcion();
            nueva.setAlumno(alumno);
            nueva.setClase(clase);
            nueva.setFechaInscripcion(LocalDateTime.now());
            nueva.setEstado(EstadoInscripcion.INSCRITA);
            inscripcionRepository.save(nueva);
        }

        return obtenerInscripcionesActivas(alumnoId);
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
