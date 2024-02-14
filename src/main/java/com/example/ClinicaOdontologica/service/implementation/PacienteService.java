package com.example.ClinicaOdontologica.service.implementation;

import com.example.ClinicaOdontologica.model.Paciente;
import com.example.ClinicaOdontologica.repository.IPacienteRepository;
import com.example.ClinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public void crearPaciente(Paciente paciente) {
        guardarPaciente(paciente);
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
        guardarPaciente(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Optional<Paciente> buscarPaciente(Long id) {
//        Optional<Paciente> paciente = pacienteRepository.findById(id);
//        PacienteDTO pacienteDTO = null;
//        if (paciente.isPresent()){
//            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
//        }
        return pacienteRepository.findById(id);
    }

    @Override
    public Set<Paciente> listarPacientes() {
        List<Paciente> listPacientes = pacienteRepository.findAll();
        Set<Paciente> setPacientes = new HashSet<>();

        for(Paciente paciente : listPacientes){
            setPacientes.add(paciente);
        }
        return setPacientes;
    }

    private void guardarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }


}
