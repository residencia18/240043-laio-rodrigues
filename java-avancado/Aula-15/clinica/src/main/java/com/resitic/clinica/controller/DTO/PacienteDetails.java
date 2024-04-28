package com.resitic.clinica.controller.DTO;

import com.resitic.clinica.controller.forms.EnderecoFORM;
import com.resitic.clinica.model.Paciente;

public record PacienteDetails(boolean ativo, String nome, String email, String telefone, String cpf, EnderecoFORM endereco) {
	public PacienteDetails(Paciente paciente) {
		this(paciente.isAtivo(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), new EnderecoFORM(paciente.getEndereco()));
	}
}
