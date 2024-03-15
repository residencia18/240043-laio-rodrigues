package com.resitic.vendas.controller.DTO;

import com.resitic.vendas.models.Cliente;

public class ClienteDTO {
    private String nome;
    private String cpf;

    public ClienteDTO() {}

    public ClienteDTO( Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
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