package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.dto.UsuarioRegistroResultadoDTO;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.model.Alumno;
import com.example.PanelAdministrativo.model.Carrera;
import com.example.PanelAdministrativo.model.Maestro;
import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.model.Usuario;
import com.example.PanelAdministrativo.repository.AlumnoRepository;
import com.example.PanelAdministrativo.repository.CarreraRepository;
import com.example.PanelAdministrativo.repository.MaestroRepository;
import com.example.PanelAdministrativo.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class RegistroUsuarioService {
    private static final String DOMINIO_INSTITUCIONAL = "@nexus.edu";
    private static final String ALFABETO_PASSWORD = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz23456789!@#$%";
    private static final Pattern ALIAS_VALIDO = Pattern.compile("^[a-zA-Z0-9._%+-]+$");
    private final SecureRandom secureRandom = new SecureRandom();

    private final UsuarioRepository usuarioRepository;
    private final AlumnoRepository alumnoRepository;
    private final MaestroRepository maestroRepository;
    private final CarreraRepository carreraRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistroUsuarioService(UsuarioRepository usuarioRepository, AlumnoRepository alumnoRepository,
                                  MaestroRepository maestroRepository, CarreraRepository carreraRepository,
                                  PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.alumnoRepository = alumnoRepository;
        this.maestroRepository = maestroRepository;
        this.carreraRepository = carreraRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioRegistroResultadoDTO registrar(String nombreCompleto, String aliasCorreo, String identificador,
                                                 String rolEntrada, Long carreraId, String numEmpleado) {
        String[] nombre = separarNombre(nombreCompleto);
        Rol rol = normalizarRol(rolEntrada);
        String correo = normalizarCorreo(aliasCorreo);
        if (usuarioRepository.existsByCorreoIgnoreCase(correo)) {
            throw new BusinessRuleException("Ya existe una cuenta con ese correo institucional.");
        }

        String identificadorNormalizado = identificador == null ? "" : identificador.trim();
        Carrera carrera = null;
        if (rol == Rol.ALUMNO) {
            if (identificadorNormalizado.isBlank()) {
                throw new BusinessRuleException("La matrícula es obligatoria para alumnos.");
            }
            if (alumnoRepository.existsByMatriculaIgnoreCase(identificadorNormalizado)) {
                throw new BusinessRuleException("Ya existe un alumno con esa matrícula.");
            }
            if (carreraId == null) {
                throw new BusinessRuleException("Selecciona la carrera del alumno.");
            }
            carrera = carreraRepository.findById(carreraId)
                    .orElseThrow(() -> new BusinessRuleException("La carrera seleccionada no existe."));
        } else if (rol == Rol.MAESTRO) {
            identificadorNormalizado = numEmpleado == null ? identificadorNormalizado : numEmpleado.trim();
            if (identificadorNormalizado.isBlank()) {
                throw new BusinessRuleException("El número de empleado es obligatorio para docentes.");
            }
            if (maestroRepository.existsByNumEmpleadoIgnoreCase(identificadorNormalizado)) {
                throw new BusinessRuleException("Ya existe un docente con ese número de empleado.");
            }
        }

        String passwordTemporal = generarPasswordTemporal();
        Usuario usuario;
        if (rol == Rol.ALUMNO) {
            Alumno alumno = new Alumno();
            alumno.setMatricula(identificadorNormalizado);
            alumno.setCarrera(carrera);
            usuario = alumno;
        } else if (rol == Rol.MAESTRO) {
            Maestro maestro = new Maestro();
            maestro.setNumEmpleado(identificadorNormalizado);
            usuario = maestro;
        } else {
            usuario = new Usuario();
        }

        usuario.setNombre(nombre[0]);
        usuario.setApellidoPaterno(nombre[1]);
        usuario.setApellidoMaterno(nombre[2]);
        usuario.setCorreo(correo);
        usuario.setCorreoInstitucional(correo);
        usuario.setContraseña(passwordEncoder.encode(passwordTemporal));
        usuario.setRol(rol);
        usuarioRepository.save(usuario);

        String etiquetaRol = switch (rol) {
            case ALUMNO -> "Alumno";
            case MAESTRO -> "Docente";
            case ADMINISTRATIVO -> "Administrativo";
        };
        return new UsuarioRegistroResultadoDTO(nombreCompleto.trim(), correo, identificadorNormalizado,
                etiquetaRol, passwordTemporal);
    }

    @Transactional(readOnly = true)
    public long contarUsuarios() {
        return usuarioRepository.count();
    }

    @Transactional(readOnly = true)
    public long contarPorRol(Rol rol) {
        return usuarioRepository.countByRol(rol);
    }

    private String[] separarNombre(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            throw new BusinessRuleException("El nombre completo es obligatorio.");
        }
        String[] partes = entrada.trim().replaceAll("\\s+", " ").split(" ");
        if (partes.length < 2) {
            throw new BusinessRuleException("Ingresa al menos nombre y apellido paterno.");
        }
        if (partes.length == 2) {
            return new String[]{partes[0], partes[1], null};
        }
        String nombres = String.join(" ", java.util.Arrays.copyOfRange(partes, 0, partes.length - 2));
        return new String[]{nombres, partes[partes.length - 2], partes[partes.length - 1]};
    }

    private String normalizarCorreo(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            throw new BusinessRuleException("El alias de correo es obligatorio.");
        }
        String valor = entrada.trim().toLowerCase(Locale.ROOT);
        String alias;
        if (valor.contains("@")) {
            if (!valor.endsWith(DOMINIO_INSTITUCIONAL)) {
                throw new BusinessRuleException("El correo debe utilizar el dominio nexus.edu.");
            }
            alias = valor.substring(0, valor.length() - DOMINIO_INSTITUCIONAL.length());
        } else {
            alias = valor;
        }
        if (!ALIAS_VALIDO.matcher(alias).matches()) {
            throw new BusinessRuleException("El alias de correo contiene caracteres no válidos.");
        }
        return alias + DOMINIO_INSTITUCIONAL;
    }

    private Rol normalizarRol(String entrada) {
        if (entrada == null) {
            throw new BusinessRuleException("Selecciona un rol para el usuario.");
        }
        String normalizado = Normalizer.normalize(entrada.trim(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toUpperCase(Locale.ROOT);
        return switch (normalizado) {
            case "ALUMNO", "ALUMNA" -> Rol.ALUMNO;
            case "DOCENTE", "MAESTRO" -> Rol.MAESTRO;
            case "ADMIN", "ADMINISTRATIVO" -> Rol.ADMINISTRATIVO;
            default -> throw new BusinessRuleException("El rol seleccionado no es válido.");
        };
    }

    private String generarPasswordTemporal() {
        StringBuilder password = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            password.append(ALFABETO_PASSWORD.charAt(secureRandom.nextInt(ALFABETO_PASSWORD.length())));
        }
        return password.toString();
    }
}
