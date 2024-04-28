package com.resitic.clinica.controller.forms;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.model.Consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ConsultaFORM(
		@JsonAlias({"idMedico", "medicoId", "medico_id"}) 
		Long id_medico, 
		
		@NotNull 
		@JsonAlias({"idPaciente", "pacienteId", "paciente_id"}) 
		Long id_paciente, 
		
		@NotNull 
		@Future 
		@JsonAlias({"dt_compra", "dataCompra"}) 
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
		LocalDateTime data,
		
		EspecialidadeENUM especialidade
		) {
	public ConsultaFORM(Consulta consulta) {
		this(consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(), consulta.getMedico().getEspecialidade());
	}
}