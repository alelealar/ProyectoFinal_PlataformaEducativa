package com.example.plataformaEscolar.repository;

import com.example.plataformaEscolar.model.PlanEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Long> {
}
