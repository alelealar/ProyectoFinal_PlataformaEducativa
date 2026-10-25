package com.example.PanelAdministrativo.config;

import com.example.PanelAdministrativo.model.Usuario;
import com.example.PanelAdministrativo.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminInitializer.class);

    private final UsuarioService usuarioService;

    public AdminInitializer(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) {
        if (usuarioService.existeAdministrador()) {
            return;
        }

        Usuario admin = new Usuario();
        admin.setNombre("Administrador");
        admin.setEmail("admin@nexus.edu");
        admin.setContrasenia("Admin123!");
        usuarioService.registrarAdministrador(admin);
        log.info("Administrador inicial creado (email: admin@nexus.edu). La contraseña se guardó con BCrypt.");
    }
}
