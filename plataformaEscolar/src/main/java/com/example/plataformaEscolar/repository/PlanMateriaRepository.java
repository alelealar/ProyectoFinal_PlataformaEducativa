package com.example.plataformaEscolar.repository;

import com.example.plataformaEscolar.model.PlanMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMateriaRepository extends JpaRepository<PlanMateria, Long> {
}
