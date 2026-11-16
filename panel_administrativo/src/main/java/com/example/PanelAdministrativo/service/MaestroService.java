package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.exception.ResourceNotFoundException;
import com.example.PanelAdministrativo.exception.WrongPasswordException;
import com.example.PanelAdministrativo.model.Maestro;
import com.example.PanelAdministrativo.repository.MaestroRepository;
import com.example.PanelAdministrativo.util.BCryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaestroService {

    @Autowired
    MaestroRepository maestroRepository;

    public List<Maestro> listarMaestros(){

        return maestroRepository.findAll();
    }

    public Maestro buscarMaestroPorId(Long id){

        return maestroRepository.findById(id).orElse(null);
    }

    public Maestro agregarMaestro(Maestro maestro){
        if (maestro != null){

            String contraseñaHash = BCryptUtils.hashContraseña(maestro.getContraseña());
            maestro.setContraseña(contraseñaHash);

            return maestroRepository.save(maestro);

        }

        throw new BusinessRuleException("No se ha podido guardar correctamente al maestro.");

    }

    public Optional<Maestro> actualizarMaestro(Long id, Maestro maestro){
        return maestroRepository.findById(id).map(
                maestroExistente -> {
                    maestroExistente.setNombre(maestro.getNombre());
                    maestroExistente.setApellidoPaterno(maestro.getApellidoPaterno());
                    maestroExistente.setApellidoMaterno(maestro.getApellidoMaterno());
                    maestroExistente.setCorreo(maestro.getCorreo());
                    maestroExistente.setCorreoInstitucional(maestro.getCorreoInstitucional());
                    maestroExistente.setTelefono(maestro.getTelefono());

                    return maestroRepository.save(maestroExistente);
                }
        );

    }

    public Optional<Maestro> actualizarMaestroParcial(Long id, Maestro maestro){
        return maestroRepository.findById(id).map(
                maestroExistente -> {
                    if(maestro.getNombre() != null) maestroExistente.setNombre(maestro.getNombre());
                    if(maestro.getApellidoPaterno() != null) maestroExistente.setApellidoPaterno(maestro.getApellidoPaterno());
                    if(maestro.getApellidoMaterno() != null) maestroExistente.setApellidoMaterno(maestro.getApellidoMaterno());
                    if(maestro.getCorreo() != null) maestroExistente.setCorreo(maestro.getCorreo());
                    if(maestro.getCorreoInstitucional() != null) maestroExistente.setCorreoInstitucional(maestro.getCorreoInstitucional());
                    if(maestro.getTelefono() != null) maestroExistente.setTelefono(maestro.getTelefono());

                    return maestroRepository.save(maestroExistente);
                }
        );

    }


    public void borrarMaestro(Long id){
        this.maestroRepository.deleteById(id);
    }

    public boolean validarContraseña(Long id, String contraseña){
        Maestro maestro = maestroRepository.findById(id).orElse(null);
        if(maestro != null){

            return BCryptUtils.verificarContraseña(contraseña, maestro.getContraseña());
        }


        throw new ResourceNotFoundException("No se ha encontrado al maestro con id: " + id);
    }


    public void cambiarContraseña(Long id, String antiguaContraseña, String nuevaContraseña){
        Maestro maestro = maestroRepository.findById(id).orElse(null);
        if (maestro != null){
            if (BCryptUtils.verificarContraseña(antiguaContraseña, maestro.getContraseña()) ){
                maestro.setContraseña(BCryptUtils.hashContraseña(nuevaContraseña));
            }
            else{
                throw new WrongPasswordException("La contraseña introducida no es correcta.");
            }

        }

        throw new ResourceNotFoundException("No se ha encontrado al maestro con id: " + id);
    }

}
