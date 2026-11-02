package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.dto.EstadisticasAdminDTO;
import com.example.PanelAdministrativo.dto.MateriaCupoDTO;
import com.example.PanelAdministrativo.model.Clase;
import com.example.PanelAdministrativo.model.HorarioClase;
import com.example.PanelAdministrativo.model.PlanMateria;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.PeriodoEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

    public EstadisticasAdminDTO obtenerEstadisticasGenerales() {
        List<Clase> clases = claseRepository.findAll();

        int totalInscritos = 0;
        int totalCapacidad = 0;
        int gruposLlenos = 0;
        int materiasActivas = clases.size();

        for (Clase clase : clases) {
            int cupoMax = clase.getCupoMaximo();
            int disponibles = clase.getCupoDisponible();
            int ocupados = cupoMax - disponibles;

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

        long periodosCount = periodoEscolarRepository.count();
        int periodosActivos = (int) periodosCount;

        EstadisticasAdminDTO stats = new EstadisticasAdminDTO();
        stats.setTotalInscritos(totalInscritos);
        stats.setMetaInscritos(metaInscritos);
        stats.setPorcentajeInscritos(porcentajeInscritos);
        stats.setPeriodosActivos(periodosActivos);
        stats.setMateriasActivas(materiasActivas);
        stats.setOcupacionGlobal(ocupacionGlobal);
        stats.setGruposLlenos(gruposLlenos);

        return stats;
    }

    public List<MateriaCupoDTO> obtenerMonitorCupos() {
        List<Clase> clases = claseRepository.findAll();
        List<MateriaCupoDTO> listaDtos = new ArrayList<>();

        for (Clase clase : clases) {
            MateriaCupoDTO dto = new MateriaCupoDTO();
            dto.setId(clase.getId());

            dto.setCodigo(clase.getClave());

            String nombreCarrera = "Sin carrera";
            if (clase.getMateria() != null) {
                dto.setNombreMateria(clase.getMateria().getNombre());
            } else {
                dto.setNombreMateria(clase.getNombre());
            }
            dto.setCarrera(nombreCarrera);

            int totalCupos = clase.getCupoMaximo();
            int disponibles = clase.getCupoDisponible();
            int ocupados = totalCupos - disponibles;

            dto.setOcupados(ocupados);
            dto.setTotalCupos(totalCupos);

            double porcentaje = 0.0;
            if (totalCupos > 0) {
                porcentaje = Math.round(((double) ocupados / totalCupos) * 100.0);
            }
            dto.setPorcentajeOcupacion(porcentaje);

            if (porcentaje >= 100.0) {
                dto.setEstado("SATURADA");
                dto.setTextoEstado("¡Saturada!");
                dto.setClaseTextoColor("text-danger");
                dto.setClaseBarraColor("barra-roja");
                dto.setPermiteAbrirGrupo(true);
                dto.setTextoAccionSecundaria("Lista de Espera");
            } else {
                if (porcentaje >= 85.0) {
                    dto.setEstado("CASI_LLENA");
                    int restan = totalCupos - ocupados;
                    dto.setTextoEstado("Casi Llena (" + restan + " cupos)");
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
            }


            if (clase.getMaestro() != null) {
                String nombreProfesor = clase.getMaestro().getNombre() + " " + clase.getMaestro().getApellidoPaterno();
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
}
