package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.repository.PeriodoEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodoEscolarService {

    @Autowired
    private PeriodoEscolarRepository periodoEscolarRepository;

}
