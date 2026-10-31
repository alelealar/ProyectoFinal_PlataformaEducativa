package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaseService {

    @Autowired
    ClaseRepository claseRepository;
}
