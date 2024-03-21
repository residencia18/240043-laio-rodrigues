package com.resitic.clinica.controller.DTO;

import com.resitic.clinica.controller.forms.EspecialidadeENUM;
import com.resitic.clinica.model.Medico;

public record MedicoDTO(long id, String nome, String email, String crm, EspecialidadeENUM Especialidade) {
	public MedicoDTO(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
