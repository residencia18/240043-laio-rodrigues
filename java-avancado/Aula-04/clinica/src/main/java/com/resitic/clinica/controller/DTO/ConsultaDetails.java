package com.resitic.clinica.controller.DTO;

import java.time.LocalDateTime;

import com.resitic.clinica.model.Consulta;

public record ConsultaDetails(Long id, Long id_medico, Long id_paciente, LocalDateTime data) {
	public ConsultaDetails(Consulta consulta) {
		this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
