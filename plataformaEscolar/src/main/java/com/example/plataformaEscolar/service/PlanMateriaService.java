package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.PlanMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanMateriaService {

    @Autowired
    PlanMateriaRepository planMateriaRepository;

}
