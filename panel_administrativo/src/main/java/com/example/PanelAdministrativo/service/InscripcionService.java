package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    @Autowired
    InscripcionRepository inscripcionRepository;

}
