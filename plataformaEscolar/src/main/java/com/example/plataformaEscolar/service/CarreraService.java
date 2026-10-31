package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {

    @Autowired
    CarreraRepository carreraRepository;
}
