package com.example.PanelAdministrativo.config;

import com.example.PanelAdministrativo.model.Alumno;
import com.example.PanelAdministrativo.model.Carrera;
import com.example.PanelAdministrativo.model.Rol;
import com.example.PanelAdministrativo.repository.AlumnoRepository;
import com.example.PanelAdministrativo.repository.CarreraRepository;
import com.example.PanelAdministrativo.service.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlumnoInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AlumnoInitializer.class);

    private final AlumnoService alumnoService;
    private final AlumnoRepository alumnoRepository;
    private final CarreraRepository carreraRepository;

    public AlumnoInitializer(AlumnoService alumnoService,
                             AlumnoRepository alumnoRepository,
                             CarreraRepository carreraRepository) {
        this.alumnoService = alumnoService;
        this.alumnoRepository = alumnoRepository;
        this.carreraRepository = carreraRepository;
    }

    @Override
    public void run(String... args) {
        String matriculaPrueba = "0021000099";

        if (alumnoRepository.findByMatricula(matriculaPrueba).isPresent()) {
            return;
        }

        Carrera carrera = carreraRepository.findById(1L).orElse(null);

        Alumno alumno = Alumno.builder()
                .nombre("Valeria")
                .apellidoPaterno("Méndez")
                .apellidoMaterno("Prueba")
                .correo("valeria.prueba@potros.itson.edu.mx")
                .correoInstitucional("valeria.prueba@potros.itson.edu.mx")
                .contraseña("123456")
                .telefono("6441234567")
                .rol(Rol.ALUMNO)
                .matricula(matriculaPrueba)
                .carrera(carrera)
                .build();

        alumnoService.agregarAlumno(alumno);
        log.info("Alumno de prueba creado (matrícula: {}, contraseña: 123456).", matriculaPrueba);
    }
}