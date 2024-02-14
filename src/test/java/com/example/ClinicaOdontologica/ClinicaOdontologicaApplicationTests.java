package com.example.ClinicaOdontologica;

import com.example.ClinicaOdontologica.dto.DomicilioDTO;
import com.example.ClinicaOdontologica.dto.OdontologoDTO;
import com.example.ClinicaOdontologica.service.implementation.DomicilioService;
import com.example.ClinicaOdontologica.service.implementation.OdontologoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClinicaOdontologicaApplicationTests {

	@Autowired
	private OdontologoService odontologoService;

	@Autowired
	private DomicilioService domicilioService;


    @Test
    public void revisarSiContieneOdontologos() {
		Set<OdontologoDTO> odontologos = odontologoService.listarOdontologos();
		Assertions.assertTrue(odontologos != null);
	}


	@Test
	public void traerOdontologo(){
		OdontologoDTO odontologoDTO = odontologoService.buscarOdontologo(3L);
		Assertions.assertTrue(odontologoDTO != null);
	}

	@Test
	public void traerDomicilios(){
		Set<DomicilioDTO> domicilios = domicilioService.listarDomicilio();
		Assertions.assertTrue(domicilios != null);
	}




}
