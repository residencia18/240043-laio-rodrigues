package com.outlaio.SistemaAviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piloto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String numBreve;
	
	public Piloto() {
		super();
	}

	public Piloto(String nome, String numBreve) {
		id = null;
		this.nome = nome;
		this.numBreve = numBreve;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumBreve() {
		return numBreve;
	}

	public void setNumBreve(String numBreve) {
		this.numBreve = numBreve;
	}
	
	
}
