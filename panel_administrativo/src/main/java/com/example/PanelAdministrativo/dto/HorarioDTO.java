package com.example.PanelAdministrativo.dto;

import com.example.PanelAdministrativo.model.Dia;

import java.time.LocalTime;

/**
 * Bloque de horario de una clase: día, hora y aula.
 */
public record HorarioDTO(
        Dia dia,
        LocalTime horaEntrada,
        LocalTime horaSalida,
        String aula
) {
}
