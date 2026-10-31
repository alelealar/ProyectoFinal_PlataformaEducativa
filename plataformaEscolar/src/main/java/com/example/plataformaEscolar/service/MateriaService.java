package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

}
