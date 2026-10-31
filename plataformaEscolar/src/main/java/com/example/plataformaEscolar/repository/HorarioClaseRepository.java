package com.example.plataformaEscolar.repository;

import com.example.plataformaEscolar.model.HorarioClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioClaseRepository extends JpaRepository<HorarioClase, Long> {
}
