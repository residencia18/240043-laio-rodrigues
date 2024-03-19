package com.resitic.clinica.controller.forms;

import jakarta.validation.constraints.NotNull;

public record UpdatePacienteFORM(@NotNull(message = "{id.obrigatorio}") long id, String nome, String telefone , EnderecoFORM endereco) {

}
