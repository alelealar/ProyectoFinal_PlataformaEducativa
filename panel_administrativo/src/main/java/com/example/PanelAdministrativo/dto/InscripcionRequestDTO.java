package com.example.PanelAdministrativo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class InscripcionRequestDTO {

    @NotEmpty(message = "Debes seleccionar al menos una clase para inscribir.")
    //notNull dentro de las <> evalua cada elemento individual, por eso lo puse ahí
    List<@NotNull(message = "El ID de la clase no puede ser nulo.") Long> claseIDs;

    public InscripcionRequestDTO(List<@NotNull(message = "El ID de la clase no puede ser nulo.") Long> claseIDs) {
        this.claseIDs = claseIDs;
    }

    public InscripcionRequestDTO() {
    }

    public List<Long> getClaseIDs() {
        return claseIDs;
    }

    public void setClaseIDs(List<Long> claseIDs) {
        this.claseIDs = claseIDs;
    }
}
