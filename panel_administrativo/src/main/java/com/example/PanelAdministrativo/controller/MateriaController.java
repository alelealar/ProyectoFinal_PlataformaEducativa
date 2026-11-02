package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.dto.ClaseGestionDTO;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.exception.ResourceNotFoundException;
import com.example.PanelAdministrativo.model.PeriodoEscolar;
import com.example.PanelAdministrativo.service.MateriaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class MateriaController {

    private static final String VISTA_GESTION = "redirect:/gestion-materias";

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping({"/gestion-materias", "/admin/materias"})
    public String mostrarGestionMaterias(@RequestParam(defaultValue = "TODAS") String estado,
                                         @RequestParam(required = false) String carrera,
                                         @RequestParam(defaultValue = "") String busqueda,
                                         HttpServletRequest request,
                                         Model model) {
        List<ClaseGestionDTO> todasLasClases = materiaService.obtenerClasesParaGestion();
        String estadoNormalizado = normalizarEstado(estado);
        String carreraSeleccionada = carrera == null ? "" : carrera.trim();
        String busquedaNormalizada = busqueda.trim();

        List<String> carreras = todasLasClases.stream()
                .map(ClaseGestionDTO::getCarrera)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());

        List<ClaseGestionDTO> clasesFiltradas = todasLasClases.stream()
                .filter(clase -> coincideEstado(clase, estadoNormalizado))
                .filter(clase -> carreraSeleccionada.isBlank()
                        || carreraSeleccionada.equalsIgnoreCase(clase.getCarrera()))
                .filter(clase -> coincideBusqueda(clase, busquedaNormalizada))
                .collect(Collectors.toList());

        int totalCupos = todasLasClases.stream().mapToInt(ClaseGestionDTO::getCupoMaximo).sum();
        int totalOcupados = todasLasClases.stream().mapToInt(ClaseGestionDTO::getOcupados).sum();
        int gruposLlenos = (int) todasLasClases.stream()
                .filter(clase -> clase.getCupoMaximo() > 0 && clase.getOcupados() >= clase.getCupoMaximo())
                .count();
        int materiasOfertadas = (int) todasLasClases.stream()
                .map(ClaseGestionDTO::getMateriaId)
                .filter(Objects::nonNull)
                .distinct()
                .count();
        double ocupacionPromedio = totalCupos == 0 ? 0.0
                : Math.round((double) totalOcupados / totalCupos * 1000.0) / 10.0;

        HttpSession session = request.getSession(false);
        Object nombreUsuario = session == null ? null : session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE);
        PeriodoEscolar periodo = materiaService.obtenerPeriodoActivo().orElse(null);

        model.addAttribute("clases", clasesFiltradas);
        model.addAttribute("docentes", materiaService.obtenerDocentes());
        model.addAttribute("carreras", carreras);
        model.addAttribute("estadoSeleccionado", estadoNormalizado);
        model.addAttribute("carreraSeleccionada", carreraSeleccionada);
        model.addAttribute("busqueda", busquedaNormalizada);
        model.addAttribute("totalGrupos", todasLasClases.size());
        model.addAttribute("materiasOfertadas", materiasOfertadas);
        model.addAttribute("totalCupos", totalCupos);
        model.addAttribute("totalOcupados", totalOcupados);
        model.addAttribute("gruposLlenos", gruposLlenos);
        model.addAttribute("gruposDisponibles", todasLasClases.size() - gruposLlenos);
        model.addAttribute("ocupacionPromedio", ocupacionPromedio);
        model.addAttribute("periodo", periodo == null ? "Sin periodo activo" : periodo.getNombrePeriodo());
        model.addAttribute("periodoActivo", periodo != null);
        model.addAttribute("nombreUsuario", nombreUsuario == null ? "Administrador" : nombreUsuario);
        return "gestion-materias";
    }

    @PostMapping("/admin/materias")
    public String crearMateria(@RequestParam String nombre,
                               @RequestParam String clave,
                               @RequestParam(required = false) String descripcion,
                               @RequestParam int creditos,
                               @RequestParam String nrc,
                               @RequestParam int cupoMaximo,
                               @RequestParam(required = false) Long docenteId,
                               RedirectAttributes redirectAttributes) {
        try {
            materiaService.crearMateriaYGrupo(nombre, clave, descripcion, creditos,
                    nrc, cupoMaximo, docenteId);
            redirectAttributes.addFlashAttribute("mensajeExito", "La materia y su grupo se crearon correctamente.");
        } catch (BusinessRuleException | ResourceNotFoundException ex) {
            redirectAttributes.addFlashAttribute("mensajeError", ex.getMessage());
        }
        return VISTA_GESTION;
    }

    @PostMapping("/admin/materias/clases/{claseId}/cupo")
    public String actualizarCupo(@PathVariable Long claseId,
                                 @RequestParam int cupoMaximo,
                                 RedirectAttributes redirectAttributes) {
        try {
            materiaService.actualizarCupo(claseId, cupoMaximo);
            redirectAttributes.addFlashAttribute("mensajeExito", "El cupo del grupo se actualizó correctamente.");
        } catch (BusinessRuleException | ResourceNotFoundException ex) {
            redirectAttributes.addFlashAttribute("mensajeError", ex.getMessage());
        }
        return VISTA_GESTION;
    }

    @PostMapping("/admin/materias/clases/{claseId}/docente")
    public String actualizarDocente(@PathVariable Long claseId,
                                    @RequestParam(required = false) Long docenteId,
                                    RedirectAttributes redirectAttributes) {
        try {
            materiaService.actualizarDocente(claseId, docenteId);
            redirectAttributes.addFlashAttribute("mensajeExito", "El docente del grupo se actualizó correctamente.");
        } catch (BusinessRuleException | ResourceNotFoundException ex) {
            redirectAttributes.addFlashAttribute("mensajeError", ex.getMessage());
        }
        return VISTA_GESTION;
    }

    private String normalizarEstado(String estado) {
        if ("LLENAS".equalsIgnoreCase(estado)) {
            return "LLENAS";
        }
        if ("DISPONIBLES".equalsIgnoreCase(estado)) {
            return "DISPONIBLES";
        }
        return "TODAS";
    }

    private boolean coincideEstado(ClaseGestionDTO clase, String estado) {
        boolean llena = clase.getCupoMaximo() > 0 && clase.getOcupados() >= clase.getCupoMaximo();
        return switch (estado) {
            case "LLENAS" -> llena;
            case "DISPONIBLES" -> !llena;
            default -> true;
        };
    }

    private boolean coincideBusqueda(ClaseGestionDTO clase, String busqueda) {
        if (busqueda.isBlank()) {
            return true;
        }
        String consulta = busqueda.toLowerCase(Locale.ROOT);
        return contiene(clase.getMateriaClave(), consulta)
                || contiene(clase.getMateriaNombre(), consulta)
                || contiene(clase.getNrc(), consulta)
                || contiene(clase.getDocente(), consulta);
    }

    private boolean contiene(String valor, String consulta) {
        return valor != null && valor.toLowerCase(Locale.ROOT).contains(consulta);
    }
}
