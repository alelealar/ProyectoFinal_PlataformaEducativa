package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.HorarioClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioClaseService {

    @Autowired
    private HorarioClaseRepository horarioClaseRepository;

}
