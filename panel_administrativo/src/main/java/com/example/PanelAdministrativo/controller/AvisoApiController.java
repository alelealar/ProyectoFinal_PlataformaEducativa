package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.dto.AvisoDTO;
import com.example.PanelAdministrativo.service.AvisoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/avisos")
public class AvisoApiController {

    private final AvisoService avisoService;

    public AvisoApiController(AvisoService avisoService) {
        this.avisoService = avisoService;
    }

    @GetMapping
    public List<AvisoDTO> avisos() {
        return avisoService.obtenerParaAlumnos();
    }
}
