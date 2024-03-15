package com.resitic.vendas.controller.DTO;

import java.math.BigDecimal;

import com.resitic.vendas.models.Pagamento;

public class PagamentoDTO {
    private BigDecimal valorPago;
    private long id_venda;

    public PagamentoDTO() {}
    
    public PagamentoDTO(Pagamento pagamento) {
        this.valorPago = pagamento.getValorPago();
        this.id_venda = pagamento.getVenda().getId();
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

	public long getId_venda() {
		return id_venda;
	}

	public void setId_venda(long id_venda) {
		this.id_venda = id_venda;
	}
    
    
}