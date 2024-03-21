package com.resitic.clinica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.forms.ConsultaFORM;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	
	public ResponseEntity<?> agendar(@RequestBody @Valid ConsultaFORM consultaDTO) {
		return ResponseEntity.ok().build();
	}
}
