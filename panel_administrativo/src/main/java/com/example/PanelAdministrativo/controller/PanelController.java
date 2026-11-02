package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.service.ClaseService;
import com.example.PanelAdministrativo.service.MateriaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;

/**
 *
 */
@Controller
public class PanelController {

    private final ClaseService claseService;
    private final MateriaService materiaService;

    public PanelController(ClaseService claseService, MateriaService materiaService) {
        this.claseService = claseService;
        this.materiaService = materiaService;
    }
    /*
    @GetMapping({"/", "/panel"})
    public String panel(HttpSession session, Model model) {
        model.addAttribute("nombre", session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE));
        return "panel";
    }

     */

    @GetMapping("/panel-administrador")
    public String mostrarPanelAdministrador(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (!AuthInterceptor.tieneSesionAdministrador(session)) {
            return "redirect:/login";
        }

        Object nombreAdmin = session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE);
        model.addAttribute("nombreUsuario", nombreAdmin == null ? "Administrador" : nombreAdmin);

        model.addAttribute("stats", claseService.obtenerEstadisticasGenerales());
        var monitorCupos = claseService.obtenerMonitorCupos();
        model.addAttribute("monitorCupos", monitorCupos);
        model.addAttribute("carrerasMonitor", monitorCupos.stream()
                .map(com.example.PanelAdministrativo.dto.MateriaCupoDTO::getCarrera)
                .distinct()
                .sorted(Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
                .toList());
        model.addAttribute("periodo", materiaService.obtenerPeriodoActivo()
                .map(com.example.PanelAdministrativo.model.PeriodoEscolar::getNombrePeriodo)
                .orElse("Sin periodo activo"));
        return "panel-administrador";
    }
}
