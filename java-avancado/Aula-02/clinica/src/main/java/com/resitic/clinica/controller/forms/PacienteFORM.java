package com.resitic.clinica.controller.forms;

public record PacienteFORM(
	String nome,
	String cpf,
	String email,
	String telefone,
	EnderecoFORM endereco
) {}
