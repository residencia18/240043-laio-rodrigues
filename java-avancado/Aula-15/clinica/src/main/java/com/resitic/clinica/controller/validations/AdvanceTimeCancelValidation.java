package com.resitic.clinica.controller.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.controller.repository.ConsultaRepository;
import com.resitic.clinica.infra.exception.ValidationException;
import com.resitic.clinica.model.Consulta;

@Component
public class AdvanceTimeCancelValidation implements CancelConsultaValidator {
	
	@Autowired
	private ConsultaRepository repository;
	
	public void validate(CancelConsultaFORM form) {		
		if (!repository.existsById(form.id_consulta()))
			throw new ValidationException("Consulta não encontrada!");
        
		Consulta consulta = repository.getReferenceById(form.id_consulta());
        LocalDateTime dateConsulta = consulta.getData();
		LocalDateTime now = LocalDateTime.now();
		Long difference = Duration.between(now, dateConsulta).toHours();
		
		if (difference < 24)
			throw new ValidationException("A consulta só pode ser cancelada com pelo menos 24 horas de antecedência!");
	}

}
