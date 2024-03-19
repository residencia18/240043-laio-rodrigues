package com.resitic.clinica.controller.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteFORM(
	@NotBlank(message = "{nome.obrigatorio}")
	String nome,
	
	@NotBlank(message = "{cpf.obrigatorio}")
	@Pattern(regexp = "\\d{11}", message = "{cpf.invalido}")
	String cpf,
	
	@NotBlank(message = "{email.obrigatorio}")
	@Email(message = "{email.invalido}")
	String email,
	
	@NotBlank(message = "{telefone.obrigatorio}")
	String telefone,
	
	@NotNull(message = "{endereco.obrigatorio}")
	@Valid
	EnderecoFORM endereco
) {}
