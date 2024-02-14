package com.example.ClinicaOdontologica.controller;


import com.example.ClinicaOdontologica.dto.OdontologoDTO;
import com.example.ClinicaOdontologica.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController()
@RequestMapping("/odontologos")
public class OdontologoController {

    private static Logger logger = Logger.getLogger(OdontologoController.class);
    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping("/add")
    public ResponseEntity<String> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.crearOdontologo(odontologoDTO);
        logger.info("Odontologo creado");
        return new ResponseEntity<>("Odontologo creado con exito.",HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        logger.info("Odontologo modificado");
        return new ResponseEntity<>("Odontologo modificado con exito ",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id){
        ResponseEntity response = null;
        if (odontologoService.buscarOdontologo(id) == null){
            response = new ResponseEntity<>("No se encontro el odontologo",HttpStatus.NOT_FOUND);
            logger.error("No se encontro el odontologo con id" + id);
        }
        else {
            odontologoService.eliminarOdontologo(id);
            response = new ResponseEntity<>("Odontologo eliminado con exito", HttpStatus.NO_CONTENT);
            logger.info("Odontologo eliminado");
        }
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> buscarOdontologo(@PathVariable Long id){
        ResponseEntity response = null;
        if (odontologoService.buscarOdontologo(id) == null){
            response = new ResponseEntity<>("No se encontro el odontologo", HttpStatus.NOT_FOUND);
            logger.error("No se encontro el odontologo con id" + id);
        }
        else {
            response = new ResponseEntity<>(odontologoService.buscarOdontologo(id), HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/get/all")
    public Set<OdontologoDTO> listarOdontologos(){
        return odontologoService.listarOdontologos();
    }


}
