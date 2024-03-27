package com.resitic.clinica.controller.forms;

import com.resitic.clinica.controller.enums.MotivoENUM;

import jakarta.validation.constraints.NotNull;

public record CancelConsultaFORM(@NotNull Long id_consulta, @NotNull MotivoENUM motivo) {

}
