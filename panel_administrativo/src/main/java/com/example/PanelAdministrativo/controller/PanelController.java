package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.service.ClaseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@Controller
public class PanelController {

    private final ClaseService claseService;

    public PanelController(ClaseService claseService) {
        this.claseService = claseService;
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

        String nombreAdmin = (String) session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE);
        model.addAttribute("nombreUsuario", nombreAdmin);

        model.addAttribute("stats", claseService.obtenerEstadisticasGenerales());
        model.addAttribute("monitorCupos", claseService.obtenerMonitorCupos());
        return "panel-administrador";
    }
}
