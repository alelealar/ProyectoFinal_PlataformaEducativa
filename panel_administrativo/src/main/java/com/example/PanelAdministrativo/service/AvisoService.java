package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.model.Aviso;
import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.repository.AvisoRepository;
import com.example.PanelAdministrativo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class AvisoService {
    private final AvisoRepository avisoRepository;
    private final UsuarioRepository usuarioRepository;

    public AvisoService(AvisoRepository avisoRepository, UsuarioRepository usuarioRepository) {
        this.avisoRepository = avisoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<Aviso> obtenerHistorial() {
        return avisoRepository.findTop10ByOrderByFechaCreacionDesc();
    }

    @Transactional(readOnly = true)
    public long contarDestinatarios(String destinatarios) {
        return switch (normalizarDestinatarios(destinatarios)) {
            case "ALUMNOS" -> usuarioRepository.countByRol(Rol.ALUMNO);
            case "DOCENTES" -> usuarioRepository.countByRol(Rol.MAESTRO);
            case "ADMINISTRATIVOS" -> usuarioRepository.countByRol(Rol.ADMINISTRATIVO);
            default -> usuarioRepository.count();
        };
    }

    @Transactional
    public Aviso publicar(String titulo, String contenido, String prioridad, String destinatarios) {
        String tituloNormalizado = titulo == null ? "" : titulo.trim();
        String contenidoNormalizado = contenido == null ? "" : contenido.trim();
        if (tituloNormalizado.isBlank() || tituloNormalizado.length() > 120) {
            throw new BusinessRuleException("El título es obligatorio y no debe exceder 120 caracteres.");
        }
        if (contenidoNormalizado.isBlank() || contenidoNormalizado.length() > 500) {
            throw new BusinessRuleException("El contenido es obligatorio y no debe exceder 500 caracteres.");
        }

        String prioridadNormalizada = prioridad == null ? "" : prioridad.trim().toUpperCase(Locale.ROOT);
        if (!"INFORMATIVO".equals(prioridadNormalizada) && !"URGENTE".equals(prioridadNormalizada)) {
            throw new BusinessRuleException("Selecciona una prioridad válida.");
        }

        String destinatariosNormalizados = normalizarDestinatarios(destinatarios);
        Aviso aviso = new Aviso();
        aviso.setTitulo(tituloNormalizado);
        aviso.setContenido(contenidoNormalizado);
        aviso.setPrioridad(prioridadNormalizada);
        aviso.setDestinatarios(destinatariosNormalizados);
        aviso.setFechaCreacion(LocalDateTime.now());
        aviso.setCantidadDestinatarios((int) contarDestinatarios(destinatariosNormalizados));
        return avisoRepository.save(aviso);
    }

    private String normalizarDestinatarios(String destinatarios) {
        String normalizado = destinatarios == null ? "" : destinatarios.trim().toUpperCase(Locale.ROOT);
        return switch (normalizado) {
            case "ALUMNOS", "DOCENTES", "ADMINISTRATIVOS", "TODOS" -> normalizado;
            default -> throw new BusinessRuleException("Selecciona un grupo de destinatarios válido.");
        };
    }
}
