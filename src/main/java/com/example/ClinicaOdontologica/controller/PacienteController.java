package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Paciente;
import com.example.ClinicaOdontologica.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/add")
    public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente){
        pacienteService.crearPaciente(paciente);
        logger.info("Paciente creado");
        return new ResponseEntity<>("Paciente creado con exito", HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modificarPaciente(@RequestBody Paciente paciente){
        pacienteService.modificarPaciente(paciente);
        logger.info("Paciente modificado");
        return new ResponseEntity<>("Paciente modificado con exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        ResponseEntity response = null;
        if (pacienteService.buscarPaciente(id) == null){
            logger.error("No se encontro el paciente con id" + id);
            response = new ResponseEntity<>("Paciente con el id " + id + " no encontrado", HttpStatus.NOT_FOUND);
        }
        else {
            pacienteService.eliminarPaciente(id);
            response = new ResponseEntity<>("Paciente eliminado con exito", HttpStatus.NO_CONTENT);
            logger.info("Paciente eliminado");
        }
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable Long id){
        ResponseEntity response = null;
        if (pacienteService.buscarPaciente(id) == null){
            response = new ResponseEntity<>("Paciente con el id " + id + " no encontrado", HttpStatus.NOT_FOUND);
        }
        else {
            response = new ResponseEntity<>(pacienteService.buscarPaciente(id), HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/get/all")
    public Set<Paciente> listarPacientes(){
        return pacienteService.listarPacientes();
    }





}
