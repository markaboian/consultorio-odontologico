package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.Turno;


import java.util.Optional;
import java.util.Set;

public interface ITurnoService {

    void crearTurno(Turno turno);
    void modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    Optional<Turno> buscarTurno(Long id);
    Set<Turno> listarTurnos();
}
