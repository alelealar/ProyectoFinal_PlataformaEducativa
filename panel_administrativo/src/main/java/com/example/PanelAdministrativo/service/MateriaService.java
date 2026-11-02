package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.dto.EstadisticasAdminDTO;
import com.example.PanelAdministrativo.dto.ClaseGestionDTO;
import com.example.PanelAdministrativo.dto.MateriaCupoDTO;
import com.example.PanelAdministrativo.model.Clase;
import com.example.PanelAdministrativo.model.Carrera;
import com.example.PanelAdministrativo.model.EstadoInscripcion;
import com.example.PanelAdministrativo.model.Maestro;
import com.example.PanelAdministrativo.model.Materia;
import com.example.PanelAdministrativo.model.PeriodoEscolar;
import com.example.PanelAdministrativo.model.PlanEstudio;
import com.example.PanelAdministrativo.model.PlanMateria;
import com.example.PanelAdministrativo.repository.ClaseRepository;
import com.example.PanelAdministrativo.repository.MaestroRepository;
import com.example.PanelAdministrativo.repository.MateriaRepository;
import com.example.PanelAdministrativo.repository.PeriodoEscolarRepository;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

    @Autowired
    private MaestroRepository maestroRepository;

    public List<Materia> obtenerTodas() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> obtenerPorId(Long id) {
        return materiaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<PeriodoEscolar> obtenerPeriodoActivo() {
        return periodoEscolarRepository.findByActivoTrue();
    }

    @Transactional(readOnly = true)
    public List<Maestro> obtenerDocentes() {
        return maestroRepository.findAll().stream()
                .sorted(Comparator.comparing(Maestro::getApellidoPaterno,
                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ClaseGestionDTO> obtenerClasesParaGestion() {
        Optional<PeriodoEscolar> periodoActivo = periodoEscolarRepository.findByActivoTrue();
        if (periodoActivo.isEmpty()) {
            return List.of();
        }

        return claseRepository.findByPeriodoEscolar_Id(periodoActivo.get().getId()).stream()
                .map(this::convertirClaseGestion)
                .sorted(Comparator.comparing(ClaseGestionDTO::getMateriaClave,
                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
                        .thenComparing(ClaseGestionDTO::getNrc,
                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .collect(Collectors.toList());
    }

    @Transactional
    public void crearMateriaYGrupo(String nombre, String clave, String descripcion,
                                   int creditos, String nrc, int cupoMaximo, Long docenteId) {
        String nombreValidado = limpiarObligatorio(nombre, "El nombre de la materia es obligatorio.");
        String claveValidada = limpiarObligatorio(clave, "La clave de la materia es obligatoria.");
        String nrcValidado = limpiarObligatorio(nrc, "El NRC del grupo es obligatorio.");

        if (creditos < 1 || creditos > 16) {
            throw new BusinessRuleException("Los créditos deben estar entre 1 y 16.");
        }
        if (cupoMaximo < 1) {
            throw new BusinessRuleException("El cupo máximo debe ser mayor que cero.");
        }
        if (materiaRepository.existsByClaveIgnoreCase(claveValidada)) {
            throw new BusinessRuleException("Ya existe una materia con esa clave.");
        }
        if (claseRepository.existsByClaveIgnoreCase(nrcValidado)) {
            throw new BusinessRuleException("Ya existe un grupo con ese NRC.");
        }

        PeriodoEscolar periodo = periodoEscolarRepository.findByActivoTrue()
                .orElseThrow(() -> new BusinessRuleException("No hay un periodo escolar activo para abrir el grupo."));
        Maestro maestro = buscarDocente(docenteId);

        Materia materia = new Materia(null, nombreValidado, claveValidada,
                descripcion == null ? null : descripcion.trim(), creditos);
        materiaRepository.save(materia);

        Clase clase = new Clase(null, "Grupo " + nrcValidado, nrcValidado,
                cupoMaximo, maestro, materia, periodo, List.of());
        claseRepository.save(clase);
    }

    @Transactional
    public void actualizarCupo(Long claseId, int nuevoCupo) {
        if (nuevoCupo < 1) {
            throw new BusinessRuleException("El cupo máximo debe ser mayor que cero.");
        }

        Clase clase = obtenerClaseDelPeriodoActivo(claseId);
        int inscritos = contarInscritosActivos(clase);
        if (nuevoCupo < inscritos) {
            throw new BusinessRuleException("El cupo no puede ser menor que los " + inscritos + " alumnos inscritos.");
        }

        clase.setCupoMaximo(nuevoCupo);
        claseRepository.save(clase);
    }

    @Transactional
    public void actualizarDocente(Long claseId, Long docenteId) {
        Clase clase = obtenerClaseDelPeriodoActivo(claseId);
        clase.setMaestro(buscarDocente(docenteId));
        claseRepository.save(clase);
    }

    private ClaseGestionDTO convertirClaseGestion(Clase clase) {
        Materia materia = clase.getMateria();
        int ocupados = contarInscritosActivos(clase);
        int cupoMaximo = clase.getCupoMaximo();
        double porcentaje = cupoMaximo > 0 ? Math.round((double) ocupados / cupoMaximo * 1000.0) / 10.0 : 0.0;
        Maestro docente = clase.getMaestro();

        return new ClaseGestionDTO(
                clase.getId(),
                materia == null ? null : materia.getId(),
                materia == null ? "-" : materia.getClave(),
                materia == null ? clase.getNombre() : materia.getNombre(),
                clase.getClave(),
                docente == null ? null : docente.getId(),
                docente == null ? "Por asignar" : nombreCompleto(docente),
                obtenerCarrera(materia),
                ocupados,
                cupoMaximo,
                Math.max(cupoMaximo - ocupados, 0),
                porcentaje
        );
    }

    private String obtenerCarrera(Materia materia) {
        if (materia == null || materia.getPlanMaterias() == null) {
            return "Sin carrera asignada";
        }
        return materia.getPlanMaterias().stream()
                .map(PlanMateria::getPlanEstudio)
                .filter(Objects::nonNull)
                .map(PlanEstudio::getCarrera)
                .filter(Objects::nonNull)
                .map(Carrera::getNombre)
                .findFirst()
                .orElse("Sin carrera asignada");
    }

    private int contarInscritosActivos(Clase clase) {
        if (clase.getInscripciones() == null) {
            return 0;
        }
        return (int) clase.getInscripciones().stream()
                .filter(inscripcion -> inscripcion.getEstado() != EstadoInscripcion.BAJA)
                .count();
    }

    private Clase obtenerClaseDelPeriodoActivo(Long claseId) {
        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el grupo solicitado."));
        PeriodoEscolar periodo = periodoEscolarRepository.findByActivoTrue()
                .orElseThrow(() -> new BusinessRuleException("No hay un periodo escolar activo."));
        if (clase.getPeriodoEscolar() == null
                || !Objects.equals(clase.getPeriodoEscolar().getId(), periodo.getId())) {
            throw new ResourceNotFoundException("El grupo no pertenece al periodo escolar activo.");
        }
        return clase;
    }

    private Maestro buscarDocente(Long docenteId) {
        if (docenteId == null) {
            return null;
        }
        return maestroRepository.findById(docenteId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el docente seleccionado."));
    }

    private String limpiarObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new BusinessRuleException(mensaje);
        }
        return valor.trim();
    }

    private String nombreCompleto(Maestro maestro) {
        return Stream.of(maestro.getNombre(), maestro.getApellidoPaterno(), maestro.getApellidoMaterno())
                .filter(parte -> parte != null && !parte.isBlank())
                .collect(Collectors.joining(" "));
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
