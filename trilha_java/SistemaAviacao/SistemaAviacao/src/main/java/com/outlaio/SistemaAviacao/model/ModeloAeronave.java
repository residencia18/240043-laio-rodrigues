package com.outlaio.SistemaAviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModeloAeronave {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fabricante;
	private String nome;
	
	public ModeloAeronave() {
		super();
	}

	public ModeloAeronave(String fabricante, String nome) {
		super();
		id = null;
		this.fabricante = fabricante;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
