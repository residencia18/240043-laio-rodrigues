package com.resitic.clinica.controller.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.repository.PacienteRepository;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class ActivePacienteValidation implements ConsultaValidator {
	
	@Autowired
	private PacienteRepository repository;
	
	public void validate(ConsultaFORM form) {
		if(!repository.findAtivoById(form.id_paciente()))
			throw new ValidationException("Consulta não pode ser agendada com paciente excluído!");
	}
}
