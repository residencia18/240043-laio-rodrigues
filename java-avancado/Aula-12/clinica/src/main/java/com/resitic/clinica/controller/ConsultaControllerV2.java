package com.resitic.clinica.controller;

import com.resitic.clinica.controller.DTO.ConsultaDetails;
import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.services.ConsultaServiceV2;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/consultas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ConsultaControllerV2 {
	
	@Autowired
	private ConsultaServiceV2 service;
	
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