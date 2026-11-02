package com.example.PanelAdministrativo.service;
import com.example.PanelAdministrativo.exception.BusinessRuleException;
import com.example.PanelAdministrativo.model.Pago;
import com.example.PanelAdministrativo.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;


    public Pago crearPago(Pago pago){
        if (pago != null){
            return pagoRepository.save(pago);

        }

        throw new BusinessRuleException("Error al crear un nuevo pago");
    }

    //pagos por id alumno


    //pagos por id periodo


    public Optional<Pago> actualizarPago(Long id, Pago pago){
        return pagoRepository.findById(id).map(
                pagoExistente ->{
                    pagoExistente.setFolio(pago.getFolio());
                    pagoExistente.setMonto(pago.getMonto());
                    pagoExistente.setConcepto(pago.getConcepto());
                    pagoExistente.setFechaPago(pago.getFechaPago());
                    pagoExistente.setEstado(pago.getEstado());

                    return pagoRepository.save(pagoExistente);
                }
        );
    }


    public Optional<Pago> actualizarPagoParcial(Long id, Pago pago){
        return pagoRepository.findById(id).map(
                pagoExistente ->{
                    if(pago.getFolio() != null) pagoExistente.setFolio(pago.getFolio());
                    if(pago.getMonto() != null) pagoExistente.setMonto(pago.getMonto());
                    if(pago.getConcepto() != null) pagoExistente.setConcepto(pago.getConcepto());
                    if(pago.getFechaPago() != null) pagoExistente.setFechaPago(pago.getFechaPago());
                    if(pago.getEstado() != null) pagoExistente.setEstado(pago.getEstado());

                    return pagoRepository.save(pagoExistente);
                }
        );
    }

}
