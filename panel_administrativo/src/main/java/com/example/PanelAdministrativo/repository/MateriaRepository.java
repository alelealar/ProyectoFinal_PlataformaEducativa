package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    boolean existsByClaveIgnoreCase(String clave);
}
