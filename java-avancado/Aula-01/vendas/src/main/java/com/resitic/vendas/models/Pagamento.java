package com.resitic.vendas.models;

import java.math.BigDecimal;

import com.resitic.vendas.controller.DTO.PagamentoDTO;
import com.resitic.vendas.controller.forms.PagamentoFORM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Pagamentos")
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "valor_pago")
	private BigDecimal valorPago;
	
	@OneToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

	public Pagamento(PagamentoFORM pagamentoFORM) {
		this.valorPago = pagamentoFORM.valorPago();
	}
	
	public Pagamento(PagamentoDTO dto) {
        this.valorPago = dto.getValorPago();
    }
	
	public Pagamento() {
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	
	public Venda getVenda() {
        return venda;
    }
	
	public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
