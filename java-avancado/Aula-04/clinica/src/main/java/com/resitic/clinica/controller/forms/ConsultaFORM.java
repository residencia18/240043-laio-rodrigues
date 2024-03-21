package com.resitic.clinica.controller.forms;

import java.time.LocalDateTime;

import com.resitic.clinica.model.Consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ConsultaFORM(Long id_medico, @NotNull Long id_paciente, @NotNull @Future LocalDateTime data) {
	public ConsultaFORM(Consulta consulta) {
		this(consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
	}
}
