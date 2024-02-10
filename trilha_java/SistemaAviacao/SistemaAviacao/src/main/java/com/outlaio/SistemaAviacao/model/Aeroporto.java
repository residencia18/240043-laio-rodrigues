package com.outlaio.SistemaAviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeroporto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ICAO;
	private String nome;
	
	public Aeroporto() {}

	public Aeroporto(String ICAO, String nome) {
		super();
		id = null;
		this.ICAO = ICAO;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getICAO() {
		return ICAO;
	}

	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
