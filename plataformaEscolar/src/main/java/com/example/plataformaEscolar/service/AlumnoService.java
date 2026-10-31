package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.model.Alumno;
import com.example.plataformaEscolar.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


    public List<Alumno> listarAlumnos(){

        return alumnoRepository.findAll();

    }


    public Alumno buscarAlumno(Long id){

        return alumnoRepository.findById(id).orElse(null);
    }


    public Alumno agregarAlumno(Alumno alumno){

        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> actualizarAlumno(Long id, Alumno alumno){
        return alumnoRepository.findById(id).map(
                alumnoExistente -> {
                    //revisar que datos si pueden modificarse y cuales no

                    alumnoExistente.setNombre(alumno.getNombre());
                    alumnoExistente.setApellidoPaterno(alumno.getApellidoPaterno());
                    alumnoExistente.setApellidoMaterno(alumno.getApellidoMaterno());
                    alumnoExistente.setCorreo(alumno.getCorreo());
                    alumnoExistente.setTelefono(alumno.getTelefono());

                    //Falta hashear contraseñasssssss
                    alumnoExistente.setContraseña(alumno.getContraseña());

                    alumnoExistente.setRol(alumno.getRol());
                    alumnoExistente.setMatricula(alumno.getMatricula());
                    alumnoExistente.setCorreoInstitucional(alumno.getCorreoInstitucional());

                    //no sé si carrera se pueda cambiar tan facilment desde aqui revisar
                    //alumnoExistente.setCarrera(alumno.getCarrera());


                    return alumnoRepository.save(alumnoExistente);
                }
        );
    }


}
