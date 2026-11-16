package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.EstadoInscripcion;
import com.example.PanelAdministrativo.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("SELECT i FROM Inscripcion i WHERE i.alumno.id = :alumnoId " +
           "AND i.clase.periodoEscolar.id = :periodoId AND i.estado <> :estadoBaja")
    List<Inscripcion> findActivasDelPeriodo(@Param("alumnoId") Long alumnoId,
                                            @Param("periodoId") Long periodoId,
                                            @Param("estadoBaja") EstadoInscripcion estadoBaja);

    @Query("SELECT i FROM Inscripcion i WHERE i.alumno.id = :alumnoId " +
           "AND i.clase.periodoEscolar.activo = false AND i.estado <> :estadoBaja " +
           "ORDER BY i.clase.periodoEscolar.fechaInicio DESC")
    List<Inscripcion> findHistorialArchivado(@Param("alumnoId") Long alumnoId,
                                             @Param("estadoBaja") EstadoInscripcion estadoBaja);
}
