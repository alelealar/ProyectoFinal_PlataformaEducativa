package com.example.PanelAdministrativo.repository;
import com.example.PanelAdministrativo.model.Alumno;
import com.example.PanelAdministrativo.model.EstadoInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    boolean existsByMatriculaIgnoreCase(String matricula);

    @Query("SELECT COUNT(DISTINCT i.alumno) FROM Inscripcion i " +
           "WHERE i.clase.periodoEscolar.id = :periodoId AND i.estado <> :estadoBaja")
    long contarMatriculadosActivos(@Param("periodoId") Long periodoId,
                                   @Param("estadoBaja") EstadoInscripcion estadoBaja);
}
