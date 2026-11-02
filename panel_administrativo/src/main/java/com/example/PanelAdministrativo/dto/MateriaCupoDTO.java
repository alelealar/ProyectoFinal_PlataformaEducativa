package com.example.PanelAdministrativo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaCupoDTO {
    private Long id;
    private String codigo;
    private String carrera;
    private String nombreMateria;

    private String estado;
    private String textoEstado;

    private String profesor;
    private String aula;
    private String horario;
    private int ocupados;
    private int totalCupos;
    private double porcentajeOcupacion;

    private String claseTextoColor;
    private String claseBarraColor;

    // Botones dinámicos opcionales
    private boolean permiteAbrirGrupo;
    private String textoAccionSecundaria;
}