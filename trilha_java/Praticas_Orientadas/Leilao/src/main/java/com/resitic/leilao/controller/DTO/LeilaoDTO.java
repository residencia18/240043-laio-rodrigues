package com.resitic.leilao.controller.DTO;

import com.resitic.leilao.model.Leilao;

// DTO da classe Leilao
public class LeilaoDTO {
	// Atributos que serão publicos
	private String Descricao;
	private double ValorMinimo;
	private boolean Status;
	
	// Construtor do DTO a partir do objeto Leilao
	public LeilaoDTO(Leilao leilao) {
		this.Descricao = leilao.getDescricao();
        this.ValorMinimo = leilao.getValorMinimo();
        this.Status = leilao.getStatus();;
	}
	
	// Getters
	
	public String getDescricao() {
        return Descricao;
    }
	
	public double getValorMinimo() {
        return ValorMinimo;
    }
	
	public boolean getStatus() {
        return Status;
    }
	
	// Método ToString
	@Override
	public String toString() {
        return "[Descricao=" + Descricao + ", ValorMinimo=" + ValorMinimo + ", Status=" + Status + "]";
    }
}
