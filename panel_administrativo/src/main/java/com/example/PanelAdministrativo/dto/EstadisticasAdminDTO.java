package com.example.PanelAdministrativo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasAdminDTO {
    private int totalInscritos;
    private int metaInscritos;
    private double porcentajeInscritos;

    private int periodosActivos;

    private int materiasActivas;
    private double ocupacionGlobal;
    private int gruposLlenos;
}
