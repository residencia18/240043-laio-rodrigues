package com.resitic.clinica.controller.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resitic.clinica.model.Consulta;

public record ConsultaDetails(Long id, Long id_medico, Long id_paciente, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime data) {
	public ConsultaDetails(Consulta consulta) {
		this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}