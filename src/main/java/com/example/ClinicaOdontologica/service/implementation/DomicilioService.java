package com.example.ClinicaOdontologica.service.implementation;


import com.example.ClinicaOdontologica.dto.DomicilioDTO;
import com.example.ClinicaOdontologica.model.Domicilio;
import com.example.ClinicaOdontologica.repository.IDomicilioRepository;
import com.example.ClinicaOdontologica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> listarDomicilio() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for (Domicilio domicilio : domicilios){
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domicilioDTOS;
    }

    private void guardarDomicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }


//    private IDao<Domicilio> domicilioIDao;
//
//    public DomicilioService(IDao<Domicilio> domicilioIDao) {
//        this.domicilioIDao = domicilioIDao;
//    }
//
//    public IDao<Domicilio> getDomicilioIDao() {
//        return domicilioIDao;
//    }
//
//    public void setDomicilioIDao(IDao<Domicilio> domicilioIDao) {
//        this.domicilioIDao = domicilioIDao;
//    }
//
//    public Domicilio registrar(Domicilio domicilio){
//        return domicilioIDao.registrar(domicilio);
//    }
//
//    public void eliminar(long id){
//        domicilioIDao.eliminar(id);
//    }
//
//    public Domicilio buscar(long id){
//        return domicilioIDao.buscar(id);
//    }
//
//    public List<Domicilio> listarTodos(){
//        return domicilioIDao.listarTodos();
//    }
}
