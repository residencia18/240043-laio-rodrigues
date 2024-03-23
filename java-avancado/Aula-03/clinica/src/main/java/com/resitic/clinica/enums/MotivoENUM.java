package com.resitic.clinica.enums;

import com.fasterxml.jackson.annotation.JsonAlias;

public enum MotivoENUM {
	
	PACIENTE_DESISTIU,
	
	@JsonAlias({"MEDICO_CANCELOU"})
	MÉDICO_CANCELOU,
	
	OUTROS;
}
