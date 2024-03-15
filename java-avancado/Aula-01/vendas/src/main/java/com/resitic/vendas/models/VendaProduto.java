package com.resitic.vendas.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Tb_Venda_Produto")
public class VendaProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private Produto produto;
	
	@Column(name = "quantidade")
	private int quantidade;

	public VendaProduto(Venda venda, Produto produto, int quantidade) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public VendaProduto() {
        
    }

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
