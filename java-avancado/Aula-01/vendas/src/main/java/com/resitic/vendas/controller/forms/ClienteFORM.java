package com.resitic.vendas.controller.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteFORM(@NotBlank String nome, @NotBlank @Pattern(regexp = "\\d{11}") String cpf) {}
