package com.resitic.clinica.controller.validations;

import org.springframework.stereotype.Component;

import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.infra.exception.ValidationException;

@Component
public class ReasonCancelValidation implements CancelConsultaValidator {

	public void validate(CancelConsultaFORM form) {
		if (form.motivo() == null)
			throw new ValidationException("É obrigatório informar o motivo do cancelamento!");
	}

}
