package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.dto.DomicilioDTO;
import com.example.ClinicaOdontologica.service.IDomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private static Logger logger = Logger.getLogger(DomicilioController.class);

    @Autowired
    private IDomicilioService domicilioService;

    @PostMapping("/add")
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        logger.info("Domicilio creado");
        return new ResponseEntity<>("Domicilio creado con exito", HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.modificarDomicilio(domicilioDTO);
        logger.info("Domicilio modificado");
        return new ResponseEntity<>("Domicilio modificado con exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        ResponseEntity response = null;
        if (domicilioService.buscarDomicilio(id) == null){
            logger.error("No se encontro el domicilio con id" + id);
            response = new ResponseEntity<>("Domicilio con id " + id + " no encontrado", HttpStatus.NOT_FOUND);
        }
        else {
            domicilioService.eliminarDomicilio(id);
            response = new ResponseEntity<>("Domicilio eliminado con exito", HttpStatus.NO_CONTENT);
            logger.info("Domicilio eliminado");
        }
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> buscarDomicilio(@PathVariable Long id){
        ResponseEntity response = null;
        if (domicilioService.buscarDomicilio(id) == null) {
            response = new ResponseEntity<>("Domicilio con id " + id + " no encontrado", HttpStatus.NOT_FOUND);
        }
        else {
            response = new ResponseEntity<>(domicilioService.buscarDomicilio(id), HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/get/all")
    public Set<DomicilioDTO> listarDomicilios(){
        return domicilioService.listarDomicilio();
    }

}
