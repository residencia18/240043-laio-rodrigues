package com.resitic.vendas.models;

import com.resitic.vendas.controller.DTO.ClienteDTO;
import com.resitic.vendas.controller.forms.ClienteFORM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;

	public Cliente(ClienteFORM clienteForm) {
		this.nome = clienteForm.nome();
		this.cpf = clienteForm.cpf();
	}
	
	public Cliente(ClienteDTO dto) {
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
    }
	
	public Cliente() {
        
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
