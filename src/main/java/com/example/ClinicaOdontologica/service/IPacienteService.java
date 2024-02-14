package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.Paciente;

import java.util.Optional;
import java.util.Set;

public interface IPacienteService {

    void crearPaciente(Paciente paciente);
    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Optional<Paciente> buscarPaciente(Long id);
    Set<Paciente> listarPacientes();
}
