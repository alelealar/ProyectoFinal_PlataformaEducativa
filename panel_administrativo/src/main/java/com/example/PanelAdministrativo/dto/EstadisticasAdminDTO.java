package com.example.PanelAdministrativo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstadisticasAdminDTO {
    private int totalInscritos;
    private int metaInscritos;
    private double porcentajeInscritos;

    private int periodosActivos;

    private int materiasActivas;
    private double ocupacionGlobal;
    private int gruposLlenos;
    private long totalUsuarios;
    private long totalAlumnos;
    private long totalDocentes;

    public EstadisticasAdminDTO() {
    }

    public EstadisticasAdminDTO(int totalInscritos, int metaInscritos, double porcentajeInscritos,
                                int periodosActivos, int materiasActivas, double ocupacionGlobal,
                                int gruposLlenos) {
        this.totalInscritos = totalInscritos;
        this.metaInscritos = metaInscritos;
        this.porcentajeInscritos = porcentajeInscritos;
        this.periodosActivos = periodosActivos;
        this.materiasActivas = materiasActivas;
        this.ocupacionGlobal = ocupacionGlobal;
        this.gruposLlenos = gruposLlenos;
    }
}
