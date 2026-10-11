package com.example.plataformaEscolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

}