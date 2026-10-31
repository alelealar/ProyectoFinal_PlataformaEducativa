package com.example.plataformaEscolar.repository;

import com.example.plataformaEscolar.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Clase, Long> {
}
