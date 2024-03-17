package com.resitic.clinica.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.forms.PacienteFORM;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@PostMapping
	public void cadastrar(@RequestBody PacienteFORM pacienteFORM) {
		
	}
}
