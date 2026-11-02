package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {

    @Autowired
    CarreraRepository carreraRepository;
}
