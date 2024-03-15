package com.resitic.vendas.controller.forms;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VendaProdutoFORM(@NotNull long id_produto, @Pattern(regexp = "\\d") int quantidade) {}
