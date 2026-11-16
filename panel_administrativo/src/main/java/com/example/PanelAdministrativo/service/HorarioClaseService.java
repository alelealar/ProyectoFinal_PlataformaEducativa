package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.model.HorarioClase;
import com.example.PanelAdministrativo.repository.HorarioClaseRepository;
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
