package com.resitic.clinica.controller.DTO;

import com.resitic.clinica.controller.forms.EnderecoFORM;
import com.resitic.clinica.controller.forms.EspecialidadeENUM;
import com.resitic.clinica.model.Medico;

public record MedicoDetails(boolean ativo, String nome, String email, String telefone, String crm, EspecialidadeENUM especialidade, EnderecoFORM endereco) {
	public MedicoDetails(Medico medico) {
		this(medico.isAtivo(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), new EnderecoFORM(medico.getEndereco()));
	}
}
