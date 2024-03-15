package com.resitic.vendas.controller.DTO;

import java.math.BigDecimal;
import java.util.List;

import com.resitic.vendas.models.Venda;

public class VendaDTO {
	private BigDecimal valorTotal;
    private boolean quitado;
    private String cliente;
    private List<VendaProdutoDTO> produtos;

    public VendaDTO() {}

    public VendaDTO(Venda venda) {
        this.valorTotal = venda.getValorTotal();
        this.quitado = venda.isQuitado();
        this.cliente = venda.getCliente().getNome();
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<VendaProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<VendaProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
}
