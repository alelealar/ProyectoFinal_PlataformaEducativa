package com.example.PanelAdministrativo.dto;

public record ResultadoFilaCsvDTO(int fila, boolean exitosa, String mensaje,
                                  UsuarioRegistroResultadoDTO usuario) {
}
