package com.resitic.vendas.controller.DTO;

import com.resitic.vendas.models.VendaProduto;

public class VendaProdutoDTO {
	private String produto;
	private int quantidade;
	
	public VendaProdutoDTO(String produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public VendaProdutoDTO(VendaProduto vendaProduto) {
		super();
        this.produto = vendaProduto.getProduto().getNome();
        this.quantidade = vendaProduto.getQuantidade();
	}

	public String getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
