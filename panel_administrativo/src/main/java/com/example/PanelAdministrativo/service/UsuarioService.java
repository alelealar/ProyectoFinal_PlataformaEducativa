package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.model.Usuario;
import com.example.PanelAdministrativo.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public static final String ROL_ADMIN = "ADMIN";

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrarAdministrador(Usuario usuario) {
        usuario.setRol(ROL_ADMIN);
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        return usuarioRepository.save(usuario);
    }

    /**
     * Valida correo y contraseña contra la base de datos.
     * Solo acepta administradores, la comparación usa BCrypt, nunca igualdad en texto plano.
     */
    public Usuario autenticarAdministrador(String email, String password) {
        if (email == null || password == null) {
            return null;
        }

        return usuarioRepository.findByEmail(email.trim())
                .filter(usuario -> ROL_ADMIN.equalsIgnoreCase(usuario.getRol()))
                .filter(usuario -> passwordEncoder.matches(password, usuario.getContrasenia()))
                .orElse(null);
    }

    public boolean existeAdministrador() {
        return usuarioRepository.existsByRol(ROL_ADMIN);
    }
}
