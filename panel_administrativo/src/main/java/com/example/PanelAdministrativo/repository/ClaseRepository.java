package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {

    @Query("SELECT c FROM Clase c JOIN c.materia.planMaterias pm WHERE pm.planEstudio.carrera.nombre = :nombreCarrera")
    List<Clase> findByCarreraNombre(@Param("nombreCarrera") String nombreCarrera);

    List<Clase> findByPeriodoEscolar_Id(Long periodoEscolarId);

    boolean existsByClaveIgnoreCase(String clave);
}
