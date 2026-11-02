package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.repository.PlanMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanMateriaService {

    @Autowired
    PlanMateriaRepository planMateriaRepository;

}
