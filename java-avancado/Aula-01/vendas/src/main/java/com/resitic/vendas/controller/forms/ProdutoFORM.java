package com.resitic.vendas.controller.forms;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProdutoFORM(@NotEmpty String nome, @NotNull BigDecimal preco) {}
