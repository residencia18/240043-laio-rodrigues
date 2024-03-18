package com.resitic.clinica.controller.forms;

import com.resitic.clinica.model.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoFORM(
		@NotBlank
		String logradouro, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep, 
		
		@NotBlank
		String cidade, 
		
		@NotBlank
		String uf, 
		
		String complemento, 
		String numero
) {
	public EnderecoFORM(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero());
    }
}
