package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.dto.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {

    void crearDomicilio(DomicilioDTO domicilioDTO);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
    DomicilioDTO buscarDomicilio(Long id);
    Set<DomicilioDTO> listarDomicilio();
}
