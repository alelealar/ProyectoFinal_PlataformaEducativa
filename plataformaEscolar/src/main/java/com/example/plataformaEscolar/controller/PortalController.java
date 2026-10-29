package com.example.plataformaEscolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/carga-academica")
    public String cargaAcademica(){
        return "carga-academica";
    }

    @GetMapping("/ajustes")
    public String ajustes(){
        return "ajustes";
    }

    @GetMapping("/registro-usuarios")
    public String registroUsuarios(){
        return "registro-usuarios";
    }

    @GetMapping("/horario")
    public String horario(){
        return "horario";
    }

}