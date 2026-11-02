package com.example.PanelAdministrativo.repository;


import com.example.PanelAdministrativo.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Clase, Long> {
}
