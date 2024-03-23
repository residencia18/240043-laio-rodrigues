package com.resitic.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.services.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> agendar(@RequestBody @Valid ConsultaFORM consultaFORM) {
		service.agendar(consultaFORM);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	@Transactional
    public ResponseEntity<?> cancelar(@RequestBody @Valid CancelConsultaFORM cancelamentoFORM) {
		System.out.println("ok 1");
        service.cancelar(cancelamentoFORM);
        System.out.println("ok 2");
        return ResponseEntity.ok().build();
    }
}