package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.service.AvisoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AvisoController {
    private final AvisoService avisoService;

    public AvisoController(AvisoService avisoService) {
        this.avisoService = avisoService;
    }

    @GetMapping("/avisos")
    public String mostrarAvisos(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        Object nombre = session == null ? null : session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE);
        model.addAttribute("nombreUsuario", nombre == null ? "Administrador" : nombre);
        model.addAttribute("avisos", avisoService.obtenerHistorial());
        model.addAttribute("alumnos", avisoService.contarDestinatarios("ALUMNOS"));
        model.addAttribute("docentes", avisoService.contarDestinatarios("DOCENTES"));
        model.addAttribute("totalUsuarios", avisoService.contarDestinatarios("TODOS"));
        return "avisos";
    }

    @PostMapping("/admin/avisos")
    public String publicarAviso(@RequestParam String titulo,
                                @RequestParam String contenido,
                                @RequestParam String prioridad,
                                @RequestParam String destinatarios,
                                RedirectAttributes redirectAttributes) {
        try {
            var aviso = avisoService.publicar(titulo, contenido, prioridad, destinatarios);
            redirectAttributes.addFlashAttribute("mensajeExito",
                    "Aviso guardado en el historial para " + aviso.getCantidadDestinatarios()
                            + " cuentas. La integración con push/correo no está configurada.");
        } catch (BusinessRuleException ex) {
            redirectAttributes.addFlashAttribute("mensajeError", ex.getMessage());
        }
        return "redirect:/avisos";
    }
}
