package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.model.Usuario;
import com.example.PanelAdministrativo.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String mostrarLogin(HttpServletRequest request) {
        if (AuthInterceptor.tieneSesionAdministrador(request.getSession(false))) {
            return "redirect:/panel";
        }
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                HttpServletRequest request,
                                Model model) {

        Usuario administrador = usuarioService.autenticarAdministrador(email, password);

        if (administrador == null) {
            model.addAttribute("error", "Credenciales inválidas. Inténtalo de nuevo.");
            model.addAttribute("email", email);
            return "login";
        }

        HttpSession sesionAnterior = request.getSession(false);
        if (sesionAnterior != null) {
            sesionAnterior.invalidate();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute(AuthInterceptor.SESSION_USUARIO_ID, administrador.getId());
        session.setAttribute(AuthInterceptor.SESSION_USUARIO_ROL, UsuarioService.ROL_ADMIN);
        session.setAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE, administrador.getNombre());

        return "redirect:/panel";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
}
