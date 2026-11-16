package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.repository.PlanEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanEstudiosService {

    @Autowired
    PlanEstudioRepository planEstudioRepository;

}
