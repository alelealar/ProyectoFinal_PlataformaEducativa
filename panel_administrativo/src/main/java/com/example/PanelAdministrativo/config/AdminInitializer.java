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

        Usuario admin = Usuario.builder()
                .nombre("Administrador")
                .apellidoPaterno("Nexus")
                .correo("admin@nexus.edu")
                .correoInstitucional("admin@nexus.edu")
                .contraseña("Admin123!")
                .build();

        usuarioService.registrarAdministrador(admin);
        log.info("Administrador inicial creado (correo: admin@nexus.edu). La contraseña se guardó con BCrypt.");
    }
}