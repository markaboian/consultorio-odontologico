package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Turno;
import com.example.ClinicaOdontologica.service.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private static Logger logger = Logger.getLogger(TurnoController.class);
    @Autowired
    private ITurnoService turnoService;

    @PostMapping("/add")
    public ResponseEntity<String> crearTurno(@RequestBody Turno turno){
        turnoService.crearTurno(turno);
        logger.info("Turno creado");
        return new ResponseEntity<>("Turno creado con exito", HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modificarTurno(@RequestBody Turno turno){
        turnoService.modificarTurno(turno);
        logger.info("Turno modificado");
        return new ResponseEntity<>("Turno modificado con exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        ResponseEntity response = null;
        if (turnoService.buscarTurno(id) == null){
            logger.error("No se encontro el turno con id" + id);
            response = new ResponseEntity<>("No se encontro el turno", HttpStatus.NOT_FOUND);
        }
        else {
            turnoService.eliminarTurno(id);
            response = new ResponseEntity<>("Turno eliminado con exito", HttpStatus.NO_CONTENT);
            logger.info("Turno eliminado");
        }
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> buscarTurno(@PathVariable Long id){
        ResponseEntity response = null;
        if (turnoService.buscarTurno(id) == null){
            response = new ResponseEntity<>("No se encontro el turno con id " + id, HttpStatus.NOT_FOUND);
        }
        else {
            response = new ResponseEntity<>(turnoService.buscarTurno(id), HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/get/all")
    public Set<Turno> listarTurnos(){
        return turnoService.listarTurnos();
    }
}
