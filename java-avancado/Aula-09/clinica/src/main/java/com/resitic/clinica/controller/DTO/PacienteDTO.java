package com.resitic.clinica.controller.DTO;

import com.resitic.clinica.model.Paciente;

public record PacienteDTO(Long id, String nome, String email, String cpf) {
	public PacienteDTO(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
