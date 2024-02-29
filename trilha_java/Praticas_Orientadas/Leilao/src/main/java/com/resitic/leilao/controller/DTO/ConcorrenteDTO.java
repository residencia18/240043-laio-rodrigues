package com.resitic.leilao.controller.DTO;

import com.resitic.leilao.model.Concorrente;

// DTO da classe Concorrente
public class ConcorrenteDTO {
	// Atributos que serão publicos
	private String nome;
	
	// Construtor do DTO a partir do objeto Concorrente
	public ConcorrenteDTO(Concorrente concorrente) {
		this.nome = concorrente.getNome();
	}
	
	// Getters
	public String getNome() {
        return nome;
    }
	
	// Método ToString
	@Override
	public String toString() {
        return "[nome=" + nome + "]";
    }
}
