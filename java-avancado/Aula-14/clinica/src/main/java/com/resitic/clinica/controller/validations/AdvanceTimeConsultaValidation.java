package com.resitic.clinica.controller.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class AdvanceTimeConsultaValidation implements ConsultaValidator {
	
	public void validate(ConsultaFORM form) {
		LocalDateTime dateConsulta = form.data();
		LocalDateTime now = LocalDateTime.now();
		Long difference = Duration.between(now, dateConsulta).toMinutes();
		
		if (difference < 30)
			throw new ValidationException("A consulta deve ser agendada com pelo menos 30 minutos de antecedência!");
	}
}
