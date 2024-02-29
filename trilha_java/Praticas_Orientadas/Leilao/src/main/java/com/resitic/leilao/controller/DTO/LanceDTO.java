package com.resitic.leilao.controller.DTO;

import com.resitic.leilao.model.Lance;

// DTO da classe Lance
public class LanceDTO {
	// Atributos que serão publicos
	private int Id_Leilao;
	private int Id_Concorrente;
	private double Valor;
	
	// Construtor do DTO a partir do objeto Lance
	public LanceDTO(Lance lance) {
		this.Id_Leilao = lance.getId_Leilao();
        this.Id_Concorrente = lance.getId_Concorrente();
        this.Valor = lance.getValor();
	}
	
	// Getters
	
	public int getId_Leilao() {
        return Id_Leilao;
    }
	
	public int getId_Concorrente() {
		return Id_Concorrente;
	}
	
	public double getValor() {
        return Valor;
    }
	
	// Método ToString
	@Override
	public String toString() {
        return "[Id_Leilao=" + Id_Leilao + ", Id_Concorrente=" + Id_Concorrente + ", Valor=" + Valor + "]";
    }
}
