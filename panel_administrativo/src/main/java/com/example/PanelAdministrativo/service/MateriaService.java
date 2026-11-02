package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.dto.EstadisticasAdminDTO;
import com.example.PanelAdministrativo.dto.MateriaCupoDTO;
import com.example.PanelAdministrativo.model.Clase;
import com.example.PanelAdministrativo.model.Materia;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.MateriaRepository;
import com.example.PanelAdministrativo.repository.PeriodoEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

    public List<Materia> obtenerTodas() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> obtenerPorId(Long id) {
        return materiaRepository.findById(id);
    }

    public EstadisticasAdminDTO obtenerEstadisticasAdmin() {
        List<Clase> clases = claseRepository.findAll();

        int totalInscritosReal = 0;
        int totalCapacidad = 0;
        int gruposLlenos = 0;
        int materiasActivas = clases.size();

        for (Clase clase : clases) {
            int cupoMax = clase.getCupoMaximo();
            int disponibles = clase.getCupoDisponible();
            int ocupados = cupoMax - disponibles;

            totalInscritosReal += ocupados;
            totalCapacidad += cupoMax;

            if (ocupados >= cupoMax) {
                gruposLlenos++;
            }
        }

        int metaInscritos = totalCapacidad;
        double porcentajeInscritos = 0.0;
        if (metaInscritos > 0) {
            porcentajeInscritos = Math.round(((double) totalInscritosReal / metaInscritos) * 100.0 * 10.0) / 10.0;
        }

        double ocupacionGlobal = 0.0;
        if (totalCapacidad > 0) {
            ocupacionGlobal = Math.round(((double) totalInscritosReal / totalCapacidad) * 100.0);
        }

        int periodosActivos = (int) periodoEscolarRepository.count();

        return new EstadisticasAdminDTO(
                totalInscritosReal,
                metaInscritos,
                porcentajeInscritos,
                periodosActivos,
                materiasActivas,
                ocupacionGlobal,
                gruposLlenos
        );
    }

    public List<MateriaCupoDTO> obtenerMonitorCuposEnVivo() {
        List<Materia> materias = materiaRepository.findAll();
        List<MateriaCupoDTO> listaDtos = new ArrayList<>();

        for (Materia materia : materias) {
            MateriaCupoDTO dto = new MateriaCupoDTO();
            dto.setId(materia.getId());
            dto.setCodigo("NRC " + materia.getId());
            dto.setNombreMateria(materia.getNombre());

            int cuposOcupados = 0;
            int totalCupos = 0;

            if (materia.getClases() != null) {
                for (Clase clase : materia.getClases()) {
                    int max = clase.getCupoMaximo();
                    int disp = clase.getCupoDisponible();
                    cuposOcupados += (max - disp);
                    totalCupos += max;
                }
            }

            double porcentaje = 0.0;
            if (totalCupos > 0) {
                porcentaje = ((double) cuposOcupados / totalCupos) * 100.0;
            }

            dto.setOcupados(cuposOcupados);
            dto.setTotalCupos(totalCupos);
            dto.setPorcentajeOcupacion(Math.round(porcentaje * 10.0) / 10.0);

            if (cuposOcupados >= totalCupos && totalCupos > 0) {
                dto.setEstado("SATURADA");
                dto.setTextoEstado("¡Saturada!");
                dto.setClaseTextoColor("text-danger");
                dto.setClaseBarraColor("danger");
                dto.setPermiteAbrirGrupo(true);
                dto.setTextoAccionSecundaria("Lista de Espera");
            } else {
                dto.setEstado("DISPONIBLE");
                dto.setTextoEstado("Disponible");
                dto.setClaseTextoColor("text-info");
                dto.setClaseBarraColor("info");
                dto.setPermiteAbrirGrupo(false);
                dto.setTextoAccionSecundaria("Detalle Grupo");
            }

            listaDtos.add(dto);
        }

        return listaDtos;
    }
}
