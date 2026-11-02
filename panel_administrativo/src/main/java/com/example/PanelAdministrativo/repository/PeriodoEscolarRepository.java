package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.PeriodoEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeriodoEscolarRepository extends JpaRepository<PeriodoEscolar, Long> {

    Optional<PeriodoEscolar> findByActivoTrue();
}
