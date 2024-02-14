package com.example.ClinicaOdontologica.service.implementation;

import com.example.ClinicaOdontologica.dto.OdontologoDTO;
import com.example.ClinicaOdontologica.model.Odontologo;
import com.example.ClinicaOdontologica.repository.IOdontologoRepository;
import com.example.ClinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();

        for(Odontologo odontologo : odontologos){
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOS;
    }

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }


}
