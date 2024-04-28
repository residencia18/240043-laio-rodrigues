package com.resitic.clinica.controller.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.repository.ConsultaRepository;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class MedicoNotAvailableValidation implements ConsultaValidator {

	@Autowired
	private ConsultaRepository repository;
	
	public void validate(ConsultaFORM form) {
		if(repository.isMedicoBusy(form.id_medico(), form.data()))
			throw new ValidationException("O médico ja possui outra consulta agendada neste mesmo horário!");
	}
}
