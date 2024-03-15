package com.resitic.vendas.controller.forms;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VendaFORM(@NotBlank String cpf_cliente,@NotNull List<VendaProdutoFORM> produtos) {}
