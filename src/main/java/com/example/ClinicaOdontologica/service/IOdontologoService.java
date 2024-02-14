package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.dto.OdontologoDTO;
import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> listarOdontologos();

}
