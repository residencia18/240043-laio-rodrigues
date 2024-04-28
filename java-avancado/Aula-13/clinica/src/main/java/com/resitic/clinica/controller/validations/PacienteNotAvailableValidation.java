package com.resitic.clinica.controller.validations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.repository.ConsultaRepository;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class PacienteNotAvailableValidation implements ConsultaValidator {
	
	@Autowired
	private ConsultaRepository repository;
	
	public void validate(ConsultaFORM form) {
		LocalDateTime open = form.data().withHour(7);
		LocalDateTime close = form.data().withHour(18);
		if(repository.existsByPacienteIdAndDataBetween(form.id_paciente(), open, close))
			throw new ValidationException("Paciente já possui uma consulta agendada nesse dia!");
	}
}
