package com.resitic.clinica.controller.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteFORM(
	@NotBlank
	String nome,
	
	@NotBlank
	@Pattern(regexp = "\\d{11}")
	String cpf,
	
	@NotBlank
	@Email
	String email,
	
	@NotBlank
	String telefone,
	
	@NotNull
	@Valid
	EnderecoFORM endereco
) {}
