package com.resitic.clinica.controller.forms;

import com.resitic.clinica.model.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoFORM(
		@NotBlank(message = "{logradouro.obrigatorio}")
		String logradouro, 
		
		@NotBlank(message = "{bairro.obrigatorio}")
		String bairro, 
		
		@NotBlank(message = "{cep.obrigatorio}")
		@Pattern(regexp = "\\d{8}", message = "{cep.invalido}")
		String cep, 
		
		@NotBlank(message = "{cidade.obrigatoria}")
		String cidade, 
		
		@NotBlank(message = "{uf.obrigatorio}")
		String uf, 
		
		String complemento, 
		String numero
) {
	public EnderecoFORM(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero());
    }
}
