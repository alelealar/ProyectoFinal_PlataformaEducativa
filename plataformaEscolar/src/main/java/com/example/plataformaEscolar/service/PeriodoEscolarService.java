package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.model.PeriodoEscolar;
import com.example.plataformaEscolar.repository.PeriodoEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodoEscolarService {

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

}
