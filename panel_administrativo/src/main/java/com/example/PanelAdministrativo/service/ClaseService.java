package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.dto.EstadisticasAdminDTO;
import com.example.PanelAdministrativo.dto.MateriaCupoDTO;
import com.example.PanelAdministrativo.model.Clase;
import com.example.PanelAdministrativo.model.EstadoInscripcion;
import com.example.PanelAdministrativo.model.HorarioClase;
import com.example.PanelAdministrativo.model.Materia;
import com.example.PanelAdministrativo.model.PlanMateria;
import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.UsuarioRepository;
import com.example.PanelAdministrativo.repository.PeriodoEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public EstadisticasAdminDTO obtenerEstadisticasGenerales() {
        List<Clase> clases = periodoEscolarRepository.findByActivoTrue()
                .map(periodo -> claseRepository.findByPeriodoEscolar_Id(periodo.getId()))
                .orElseGet(List::of);

        int totalInscritos = 0;
        int totalCapacidad = 0;
        int gruposLlenos = 0;
        int materiasActivas = (int) clases.stream()
                .map(Clase::getMateria)
                .filter(Objects::nonNull)
                .map(Materia::getId)
                .distinct()
                .count();

        for (Clase clase : clases) {
            int cupoMax = clase.getCupoMaximo();
            int ocupados = contarInscritosActivos(clase);

            totalInscritos += ocupados;
            totalCapacidad += cupoMax;

            if (ocupados >= cupoMax) {
                gruposLlenos++;
            }
        }

        int metaInscritos = totalCapacidad;

        double porcentajeInscritos = 0.0;
        if (metaInscritos > 0) {
            porcentajeInscritos = Math.round(((double) totalInscritos / metaInscritos) * 100.0 * 10.0) / 10.0;
        }

        double ocupacionGlobal = 0.0;
        if (totalCapacidad > 0) {
            ocupacionGlobal = Math.round(((double) totalInscritos / totalCapacidad) * 100.0);
        }

        long periodosCount = periodoEscolarRepository.countByActivoTrue();
        int periodosActivos = (int) periodosCount;

        EstadisticasAdminDTO stats = new EstadisticasAdminDTO();
        stats.setTotalInscritos(totalInscritos);
        stats.setMetaInscritos(metaInscritos);
        stats.setPorcentajeInscritos(porcentajeInscritos);
        stats.setPeriodosActivos(periodosActivos);
        stats.setMateriasActivas(materiasActivas);
        stats.setOcupacionGlobal(ocupacionGlobal);
        stats.setGruposLlenos(gruposLlenos);
        stats.setTotalUsuarios(usuarioRepository.count());
        stats.setTotalAlumnos(usuarioRepository.countByRol(Rol.ALUMNO));
        stats.setTotalDocentes(usuarioRepository.countByRol(Rol.MAESTRO));

        return stats;
    }

    @Transactional(readOnly = true)
    public List<MateriaCupoDTO> obtenerMonitorCupos() {
        List<Clase> clases = periodoEscolarRepository.findByActivoTrue()
                .map(periodo -> claseRepository.findByPeriodoEscolar_Id(periodo.getId()))
                .orElseGet(List::of);
        List<MateriaCupoDTO> listaDtos = new ArrayList<>();

        for (Clase clase : clases) {
            MateriaCupoDTO dto = new MateriaCupoDTO();
            dto.setId(clase.getId());

            dto.setCodigo(clase.getClave());

            String nombreCarrera = "Sin carrera asignada";
            if (clase.getMateria() != null) {
                dto.setNombreMateria(clase.getMateria().getNombre());
                String carreraMateria = clase.getMateria().getPlanMaterias() == null ? "Sin carrera asignada"
                        : clase.getMateria().getPlanMaterias().stream()
                        .map(PlanMateria::getPlanEstudio)
                        .filter(Objects::nonNull)
                        .map(com.example.PanelAdministrativo.model.PlanEstudio::getCarrera)
                        .filter(Objects::nonNull)
                        .map(com.example.PanelAdministrativo.model.Carrera::getNombre)
                        .findFirst()
                        .orElse("Sin carrera asignada");
                nombreCarrera = carreraMateria;
            } else {
                dto.setNombreMateria(clase.getNombre());
            }
            dto.setCarrera(nombreCarrera);

            int totalCupos = clase.getCupoMaximo();
            int ocupados = contarInscritosActivos(clase);
            int disponibles = Math.max(totalCupos - ocupados, 0);

            dto.setOcupados(ocupados);
            dto.setTotalCupos(totalCupos);

            double porcentaje = 0.0;
            if (totalCupos > 0) {
                porcentaje = Math.round(((double) ocupados / totalCupos) * 1000.0) / 10.0;
            }
            dto.setPorcentajeOcupacion(porcentaje);

            if (totalCupos > 0 && ocupados >= totalCupos) {
                dto.setEstado("SATURADA");
                dto.setTextoEstado("¡Saturada!");
                dto.setClaseTextoColor("text-danger");
                dto.setClaseBarraColor("barra-roja");
                dto.setPermiteAbrirGrupo(true);
                dto.setTextoAccionSecundaria("Lista de Espera");
            } else if (porcentaje >= 85.0) {
                    dto.setEstado("CASI_LLENA");
                    dto.setTextoEstado("Casi Llena (" + disponibles + " cupos)");
                    dto.setClaseTextoColor("text-warning");
                    dto.setClaseBarraColor("barra-naranja");
                    dto.setPermiteAbrirGrupo(false);
                    dto.setTextoAccionSecundaria("Detalle Grupo");
            } else {
                    dto.setEstado("DISPONIBLE");
                    dto.setTextoEstado("Disponible");
                    dto.setClaseTextoColor("text-info");
                    dto.setClaseBarraColor("barra-azul");
                    dto.setPermiteAbrirGrupo(false);
                    dto.setTextoAccionSecundaria("Detalle Grupo");
            }


            if (clase.getMaestro() != null) {
                String nombreProfesor = clase.getMaestro().getNombre() + " " + clase.getMaestro().getApellidoPaterno()
                        + (clase.getMaestro().getApellidoMaterno() == null ? "" : " " + clase.getMaestro().getApellidoMaterno());
                dto.setProfesor(nombreProfesor);
            } else {
                dto.setProfesor("Por asignar");
            }


            String aulaStr = "Por asignar";
            String horarioStr = "Por definir";
            List<HorarioClase> horarios = clase.getHorarios();
            if (horarios != null && !horarios.isEmpty()) {
                HorarioClase primerHorario = horarios.get(0);
                if (primerHorario != null) {
                    if (primerHorario.getAula() != null) {
                        aulaStr = primerHorario.getAula();
                    }
                    if (primerHorario.getDias() != null && primerHorario.getHoraEntrada() != null && primerHorario.getHoraSalida() != null) {
                        horarioStr = primerHorario.getDias() + " " + primerHorario.getHoraEntrada() + " - " + primerHorario.getHoraSalida();
                    }
                }
            }
            dto.setAula(aulaStr);
            dto.setHorario(horarioStr);

            listaDtos.add(dto);
        }

        return listaDtos;
    }

    private int contarInscritosActivos(Clase clase) {
        if (clase.getInscripciones() == null) {
            return 0;
        }
        return (int) clase.getInscripciones().stream()
                .filter(inscripcion -> inscripcion.getEstado() != EstadoInscripcion.BAJA)
                .count();
    }
}
