package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.model.Usuario;
import com.example.PanelAdministrativo.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public static final String ROL_ADMIN = Rol.ADMINISTRATIVO.name();

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Guarda un usuario con rol ADMIN. La contraseña recibida en texto plano
     * se cifra con BCrypt antes de persistirse.
     */
    public Usuario registrarAdministrador(Usuario usuario) {
        usuario.setRol(Rol.ADMINISTRATIVO);
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
    }

    /**
     * Valida correo y contraseña contra la base de datos.
     * Solo acepta administradores y la comparación usa BCrypt, nunca igualdad en texto plano.
     *
     * @return el administrador autenticado, o null si las credenciales no son válidas
     */
    public Usuario autenticarAdministrador(String correo, String contraseña) {
        if (correo == null || contraseña == null) {
            return null;
        }

        return usuarioRepository.findByCorreo(correo.trim())
                .filter(usuario -> Rol.ADMINISTRATIVO.equals(usuario.getRol()))
                .filter(usuario -> passwordEncoder.matches(contraseña, usuario.getContraseña()))
                .orElse(null);
    }

    public boolean existeAdministrador() {
        return usuarioRepository.existsByRol(Rol.ADMINISTRATIVO);
    }
}