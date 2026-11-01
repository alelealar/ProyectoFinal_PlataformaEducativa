package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.exception.BusinessRuleException;
import com.example.plataformaEscolar.exception.ResourceNotFoundException;
import com.example.plataformaEscolar.exception.WrongPasswordException;
import com.example.plataformaEscolar.model.Alumno;
import com.example.plataformaEscolar.repository.AlumnoRepository;
import com.example.plataformaEscolar.util.BCryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


    public List<Alumno> listarAlumnos() {

        return alumnoRepository.findAll();

    }


    public Alumno buscarAlumnoPorId(Long id) {

        return alumnoRepository.findById(id).orElse(null);
    }


    public Alumno agregarAlumno(Alumno alumno) {
        if (alumno != null) {
            String contraseñaHash = BCryptUtils.hashContraseña(alumno.getContraseña());
            alumno.setContraseña(contraseñaHash);

            return alumnoRepository.save(alumno);

        }

        throw new BusinessRuleException("No se ha podido guardar al alumno debido a un error con los datos.");

    }

    public Optional<Alumno> actualizarAlumno(Long id, Alumno alumno) {
        return alumnoRepository.findById(id).map(
                alumnoExistente -> {
                    //revisar que datos si pueden modificarse y cuales no

                    alumnoExistente.setNombre(alumno.getNombre());
                    alumnoExistente.setApellidoPaterno(alumno.getApellidoPaterno());
                    alumnoExistente.setApellidoMaterno(alumno.getApellidoMaterno());
                    alumnoExistente.setCorreo(alumno.getCorreo());
                    alumnoExistente.setCorreoInstitucional(alumno.getCorreoInstitucional());
                    alumnoExistente.setTelefono(alumno.getTelefono());

                    //no sé si carrera se pueda cambiar tan facilment desde aqui revisar
                    //alumnoExistente.setCarrera(alumno.getCarrera());


                    return alumnoRepository.save(alumnoExistente);
                }
        );
    }


    public Optional<Alumno> actualizarAlumnoParcial(Long id, Alumno alumno) {
        return alumnoRepository.findById(id).map(
                alumnoExistente -> {
                    //revisar que datos si pueden modificarse y cuales no

                    if (alumno.getNombre() != null) alumnoExistente.setNombre(alumno.getNombre());
                    if (alumno.getApellidoPaterno() != null)
                        alumnoExistente.setApellidoPaterno(alumno.getApellidoPaterno());
                    if (alumno.getApellidoMaterno() != null)
                        alumnoExistente.setApellidoMaterno(alumno.getApellidoMaterno());
                    if (alumno.getCorreo() != null) alumnoExistente.setCorreo(alumno.getCorreo());
                    if (alumno.getCorreoInstitucional() != null)
                        alumnoExistente.setCorreoInstitucional(alumno.getCorreoInstitucional());
                    if (alumno.getTelefono() != null) alumnoExistente.setTelefono(alumno.getTelefono());

                    //no sé si carrera se pueda cambiar tan facilment desde aqui revisar
                    //alumnoExistente.setCarrera(alumno.getCarrera());


                    return alumnoRepository.save(alumnoExistente);
                }
        );
    }

    public void borrarAlumno(Long id) {
        alumnoRepository.deleteById(id);

    }

    public boolean validarContraseña(Long id, String contraseña){
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if(alumno != null){

            return BCryptUtils.verificarContraseña(contraseña, alumno.getContraseña());
        }


        throw new ResourceNotFoundException("No se ha encontrado al alumno con id: " + id);

    }

    public void cambiarContraseña(Long id, String antiguaContraseña, String nuevaContraseña){
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null){
            if (BCryptUtils.verificarContraseña(antiguaContraseña, alumno.getContraseña()) ){
                alumno.setContraseña(BCryptUtils.hashContraseña(nuevaContraseña));
            }
            else{
                throw new WrongPasswordException("La contraseña introducida no es correcta.");
            }

        }

        throw new ResourceNotFoundException("No se ha encontrado al alumno con id: " + id);
    }



}
