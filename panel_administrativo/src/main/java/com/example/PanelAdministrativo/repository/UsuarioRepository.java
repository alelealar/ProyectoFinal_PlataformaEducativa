package com.example.PanelAdministrativo.repository;

import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByRol(Rol rol);

    boolean existsByCorreoIgnoreCase(String correo);

    long countByRol(Rol rol);
}