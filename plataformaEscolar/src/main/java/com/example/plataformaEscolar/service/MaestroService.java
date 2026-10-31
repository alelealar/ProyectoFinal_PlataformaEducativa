package com.example.plataformaEscolar.service;

import com.example.plataformaEscolar.repository.MaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaestroService {

    @Autowired
    MaestroRepository maestroRepository;

}
