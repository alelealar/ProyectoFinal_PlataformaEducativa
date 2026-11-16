package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.PlanMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMateriaRepository extends JpaRepository<PlanMateria, Long> {
}
