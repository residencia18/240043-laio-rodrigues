package com.resitic.vendas.models;

import java.math.BigDecimal;

import com.resitic.vendas.controller.DTO.ProdutoDTO;
import com.resitic.vendas.controller.forms.ProdutoFORM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco")
	private BigDecimal preco;

	public Produto(ProdutoFORM produtoForm) {
		this.nome = produtoForm.nome();
		this.preco = produtoForm.preco();
	}
	
	public Produto(ProdutoDTO dto) {
        this.nome = dto.getNome();
        this.preco = dto.getPreco();
    }
	
	public Produto() {
        
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
