package com.example.PanelAdministrativo.repository;


import com.example.PanelAdministrativo.model.HorarioClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioClaseRepository extends JpaRepository<HorarioClase, Long> {
}
