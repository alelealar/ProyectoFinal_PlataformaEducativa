package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
    List<Aviso> findTop10ByOrderByFechaCreacionDesc();
}
