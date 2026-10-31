package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.PlanEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanEstudiosService {

    @Autowired
    PlanEstudioRepository planEstudioRepository;

}
