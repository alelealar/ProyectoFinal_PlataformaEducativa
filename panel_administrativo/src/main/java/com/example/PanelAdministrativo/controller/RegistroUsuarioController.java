package com.example.PanelAdministrativo.controller;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.dto.ResultadoFilaCsvDTO;
import com.example.PanelAdministrativo.dto.UsuarioRegistroResultadoDTO;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.model.Carrera;
import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.repository.CarreraRepository;
import com.example.PanelAdministrativo.service.RegistroUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class RegistroUsuarioController {
    private static final long TAMANO_MAXIMO_CSV = 1024 * 1024;
    private static final int MAXIMO_FILAS_CSV = 500;
    private final RegistroUsuarioService registroUsuarioService;
    private final CarreraRepository carreraRepository;

    public RegistroUsuarioController(RegistroUsuarioService registroUsuarioService,
                                     CarreraRepository carreraRepository) {
        this.registroUsuarioService = registroUsuarioService;
        this.carreraRepository = carreraRepository;
    }

    @GetMapping("/registro-usuarios")
    public String mostrarRegistro(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        Object nombre = session == null ? null : session.getAttribute(AuthInterceptor.SESSION_USUARIO_NOMBRE);
        model.addAttribute("nombreUsuario", nombre == null ? "Administrador" : nombre);
        model.addAttribute("carreras", carreraRepository.findAll());
        model.addAttribute("totalUsuarios", registroUsuarioService.contarUsuarios());
        model.addAttribute("totalAlumnos", registroUsuarioService.contarPorRol(Rol.ALUMNO));
        model.addAttribute("totalDocentes", registroUsuarioService.contarPorRol(Rol.MAESTRO));
        return "registro-usuarios";
    }

    @PostMapping("/admin/usuarios")
    public String registrarUsuario(@RequestParam String nombreCompleto,
                                   @RequestParam String aliasCorreo,
                                   @RequestParam(required = false) String identificador,
                                   @RequestParam String rol,
                                   @RequestParam(required = false) Long carreraId,
                                   @RequestParam(required = false) String numEmpleado,
                                   RedirectAttributes redirectAttributes) {
        try {
            UsuarioRegistroResultadoDTO resultado = registroUsuarioService.registrar(
                    nombreCompleto, aliasCorreo, identificador, rol, carreraId, numEmpleado);
            redirectAttributes.addFlashAttribute("usuarioCreado", resultado);
        } catch (BusinessRuleException ex) {
            redirectAttributes.addFlashAttribute("mensajeError", ex.getMessage());
        }
        return "redirect:/registro-usuarios";
    }

    @PostMapping("/admin/usuarios/csv")
    public String importarCsv(@RequestParam("archivo") MultipartFile archivo,
                              RedirectAttributes redirectAttributes) {
        if (archivo.isEmpty()) {
            redirectAttributes.addFlashAttribute("mensajeError", "Selecciona un archivo CSV para importar.");
            return "redirect:/registro-usuarios";
        }
        if (archivo.getSize() > TAMANO_MAXIMO_CSV) {
            redirectAttributes.addFlashAttribute("mensajeError", "El archivo CSV no puede superar 2 MB.");
            return "redirect:/registro-usuarios";
        }

        try {
            String contenido = new String(archivo.getBytes(), StandardCharsets.UTF_8);
            importarFilas(contenido, redirectAttributes);
        } catch (java.io.IOException ex) {
            redirectAttributes.addFlashAttribute("mensajeError", "No fue posible leer el archivo CSV.");
        }
        return "redirect:/registro-usuarios";
    }

    private void importarFilas(String contenido, RedirectAttributes redirectAttributes) {
        String[] lineas = contenido.replace("\uFEFF", "").split("\\R");
        int encabezado = 0;
        while (encabezado < lineas.length && lineas[encabezado].isBlank()) {
            encabezado++;
        }
        if (encabezado == lineas.length) {
            redirectAttributes.addFlashAttribute("mensajeError", "El archivo CSV está vacío.");
            return;
        }

        List<String> nombresColumnas = parsearFilaCsv(lineas[encabezado]).stream()
                .map(this::normalizarColumna)
                .toList();
        Map<String, Integer> columnas = new HashMap<>();
        for (int i = 0; i < nombresColumnas.size(); i++) {
            columnas.put(nombresColumnas.get(i), i);
        }
        if (!columnas.containsKey("nombre_completo") || !columnas.containsKey("correo_alias")
                || !columnas.containsKey("rol")) {
            redirectAttributes.addFlashAttribute("mensajeError",
                    "El CSV debe incluir encabezados nombre_completo, correo_alias y rol.");
            return;
        }

        Map<String, Carrera> carreras = new HashMap<>();
        for (Carrera carrera : carreraRepository.findAll()) {
            carreras.put(normalizarValor(carrera.getNombre()), carrera);
        }

        List<ResultadoFilaCsvDTO> resultados = new ArrayList<>();
        int datosProcesados = 0;
        for (int i = encabezado + 1; i < lineas.length; i++) {
            if (lineas[i].isBlank()) {
                continue;
            }
            datosProcesados++;
            if (datosProcesados > MAXIMO_FILAS_CSV) {
                redirectAttributes.addFlashAttribute("mensajeError",
                        "Se alcanzó el límite de " + MAXIMO_FILAS_CSV + " registros por archivo.");
                break;
            }
            List<String> celdas = parsearFilaCsv(lineas[i]);
            try {
                String nombre = obtenerColumna(celdas, columnas, "nombre_completo");
                String correo = obtenerColumna(celdas, columnas, "correo_alias");
                String rol = obtenerColumna(celdas, columnas, "rol");
                String identificador = obtenerColumnaOpcional(celdas, columnas, "matricula");
                String empleado = obtenerColumnaOpcional(celdas, columnas, "num_empleado");
                if (empleado.isBlank()) {
                    empleado = obtenerColumnaOpcional(celdas, columnas, "identificador");
                }
                String carreraNombre = obtenerColumnaOpcional(celdas, columnas, "carrera");
                Long carreraId = null;
                if (!carreraNombre.isBlank()) {
                    Carrera carrera = carreras.get(normalizarValor(carreraNombre));
                    if (carrera == null) {
                        throw new BusinessRuleException("La carrera '" + carreraNombre + "' no está registrada.");
                    }
                    carreraId = carrera.getId();
                }
                UsuarioRegistroResultadoDTO usuario = registroUsuarioService.registrar(
                        nombre, correo, identificador, rol, carreraId, empleado);
                resultados.add(new ResultadoFilaCsvDTO(i + 1, true, "Cuenta creada", usuario));
            } catch (BusinessRuleException ex) {
                resultados.add(new ResultadoFilaCsvDTO(i + 1, false, ex.getMessage(), null));
            }
        }
        redirectAttributes.addFlashAttribute("resultadosCsv", resultados);
        redirectAttributes.addFlashAttribute("mensajeCsv",
                "Procesadas " + resultados.size() + " filas: "
                        + resultados.stream().filter(ResultadoFilaCsvDTO::exitosa).count() + " cuentas creadas y "
                        + resultados.stream().filter(resultado -> !resultado.exitosa()).count() + " con error.");
    }

    private List<String> parsearFilaCsv(String linea) {
        List<String> resultado = new ArrayList<>();
        StringBuilder celda = new StringBuilder();
        boolean entreComillas = false;
        for (int i = 0; i < linea.length(); i++) {
            char caracter = linea.charAt(i);
            if (caracter == '"') {
                if (entreComillas && i + 1 < linea.length() && linea.charAt(i + 1) == '"') {
                    celda.append('"');
                    i++;
                } else {
                    entreComillas = !entreComillas;
                }
            } else if (caracter == ',' && !entreComillas) {
                resultado.add(celda.toString().trim());
                celda.setLength(0);
            } else {
                celda.append(caracter);
            }
        }
        resultado.add(celda.toString().trim());
        return resultado;
    }

    private String obtenerColumna(List<String> celdas, Map<String, Integer> columnas, String clave) {
        String valor = obtenerColumnaOpcional(celdas, columnas, clave);
        if (valor.isBlank()) {
            throw new BusinessRuleException("Falta el valor requerido en la columna " + clave + ".");
        }
        return valor;
    }

    private String obtenerColumnaOpcional(List<String> celdas, Map<String, Integer> columnas, String clave) {
        Integer indice = columnas.get(clave);
        return indice == null || indice >= celdas.size() ? "" : celdas.get(indice).trim();
    }

    private String normalizarColumna(String valor) {
        return Normalizer.normalize(valor.trim().toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").replace(' ', '_');
    }

    private String normalizarValor(String valor) {
        return Normalizer.normalize(valor.trim().toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }
}
