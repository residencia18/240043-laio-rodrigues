package com.resitic.vendas.controller.forms;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record PagamentoFORM(@NotNull BigDecimal valorPago, @NotNull Long id_venda) {}
