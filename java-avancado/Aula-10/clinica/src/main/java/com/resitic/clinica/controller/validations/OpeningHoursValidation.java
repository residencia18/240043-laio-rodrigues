package com.resitic.clinica.controller.validations;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class OpeningHoursValidation implements ConsultaValidator {
	
	public void validate(ConsultaFORM form) {
		LocalDateTime data = form.data();
		
		boolean domingo = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		boolean beforeOpen = data.getHour() < 7;
		boolean afterClose = data.getHour() > 18;
		
		if(domingo || beforeOpen || afterClose)
			throw new ValidationException("Consulta fora do horário de expediente da clínica!");
	}
}
