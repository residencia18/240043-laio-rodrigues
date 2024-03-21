package com.resitic.clinica.controller.DTO;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(@NotBlank String login, @NotBlank String senha) {

}
