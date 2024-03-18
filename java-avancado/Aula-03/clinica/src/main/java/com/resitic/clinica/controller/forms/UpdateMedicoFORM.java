package com.resitic.clinica.controller.forms;

import jakarta.validation.constraints.NotNull;

public record UpdateMedicoFORM(@NotNull long id, String nome, String telefone, EnderecoFORM endereco) {

}
