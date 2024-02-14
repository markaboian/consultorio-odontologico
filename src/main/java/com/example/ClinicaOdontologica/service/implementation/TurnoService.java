package com.example.ClinicaOdontologica.service.implementation;

import com.example.ClinicaOdontologica.model.Turno;
import com.example.ClinicaOdontologica.repository.ITurnoRepository;
import com.example.ClinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TurnoService implements ITurnoService {
    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public void crearTurno(Turno turno) {
        guardarTurno(turno);
    }

    @Override
    public void modificarTurno(Turno turno) {
        guardarTurno(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Set<Turno> listarTurnos() {
        List<Turno> listaTurnos = turnoRepository.findAll();
        Set<Turno> setTurno = new HashSet<>();
        for (Turno turno : listaTurnos){
            setTurno.add(turno);
        }
        return setTurno;
    }

    private void guardarTurno(Turno turno){
        turnoRepository.save(turno);
    }
}
