package com.example.plataformaEscolar.repository;

import com.example.plataformaEscolar.model.PeriodoEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoEscolarRepository extends JpaRepository<PeriodoEscolar, Long> {
}
