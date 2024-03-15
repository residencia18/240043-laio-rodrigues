package com.resitic.vendas.controller.DTO;

import java.math.BigDecimal;

import com.resitic.vendas.models.Produto;

public class ProdutoDTO {
	private String nome;
    private BigDecimal preco;

    public ProdutoDTO() {}

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
