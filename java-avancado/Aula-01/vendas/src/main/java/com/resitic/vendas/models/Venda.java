package com.resitic.vendas.models;

import java.math.BigDecimal;

import com.resitic.vendas.controller.DTO.VendaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Tb_Vendas")
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	@Column(name = "quitado")
	private boolean quitado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToOne(mappedBy = "venda", cascade = CascadeType.ALL)
    private Pagamento pagamento;

	public Venda(BigDecimal valorTotal, boolean quitado, Cliente cliente) {
		this.valorTotal = valorTotal;
		this.quitado = quitado;
		this.cliente = cliente;
	}
	
	public Venda(VendaDTO dto) {
		this.valorTotal = dto.getValorTotal();
		this.quitado = dto.isQuitado();
//        this.cliente = dto.getCliente();
//        this.pagamento = dto.getPagamento();
    }
	
	public Venda() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
