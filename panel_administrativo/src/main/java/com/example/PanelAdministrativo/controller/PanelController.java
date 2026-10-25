package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PanelController {

    @GetMapping({"/", "/panel"})
    public String panel(HttpSession session, Model model) {
        model.addAttribute("nombre", session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE));
        return "panel";
    }
}
