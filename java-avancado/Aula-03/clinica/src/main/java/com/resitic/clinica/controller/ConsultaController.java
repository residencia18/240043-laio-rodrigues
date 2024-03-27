package com.resitic.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.DTO.ConsultaDetails;
import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.services.ConsultaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> agendar(@RequestBody @Valid ConsultaFORM consultaFORM) {
		ConsultaDetails consulta = service.agendar(consultaFORM);
		return ResponseEntity.ok(consulta);
	}
	
	@DeleteMapping
	@Transactional
    public ResponseEntity<?> cancelar(@RequestBody @Valid CancelConsultaFORM cancelamentoFORM) {
        service.cancelar(cancelamentoFORM);
        return ResponseEntity.ok().build();
    }
}