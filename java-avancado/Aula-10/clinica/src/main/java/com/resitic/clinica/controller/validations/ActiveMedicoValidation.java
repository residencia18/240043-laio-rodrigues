package com.resitic.clinica.controller.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.repository.MedicoRepository;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class ActiveMedicoValidation implements ConsultaValidator {
	
	@Autowired
	private MedicoRepository repository;
	
	public void validate(ConsultaFORM form) {
		if(form.id_medico() == null) return;
		
		if(!repository.findAtivoById(form.id_medico()))
			throw new ValidationException("O médico selecionado não está mais ativo para consultas!");
	}
}
