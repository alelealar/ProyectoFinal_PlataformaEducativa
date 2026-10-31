package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    @Autowired
    InscripcionRepository inscripcionRepository;

}
