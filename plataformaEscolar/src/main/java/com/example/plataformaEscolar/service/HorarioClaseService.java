package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.exception.BusinessRuleException;
import com.example.plataformaEscolar.model.HorarioClase;
import com.example.plataformaEscolar.repository.HorarioClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioClaseService {

    @Autowired
    private HorarioClaseRepository horarioClaseRepository;


    public HorarioClase crearHorarioClase(HorarioClase horarioClase){
        if (horarioClase != null){
            return horarioClaseRepository.save(horarioClase);
        }

        throw new BusinessRuleException("Hubo un error al crera un nuevo horario para la clase");
    }

    //buscar horarios por ID de clase




}
