package com.example.PanelAdministrativo.repository;


import com.example.PanelAdministrativo.model.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro, Long> {
    boolean existsByNumEmpleadoIgnoreCase(String numEmpleado);
}
