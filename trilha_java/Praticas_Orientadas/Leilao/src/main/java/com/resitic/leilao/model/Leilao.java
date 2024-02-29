package com.resitic.leilao.model;

import com.resitic.leilao.utils.Verificacoes;

public class Leilao {
	
	// Atributos da classe Leilão
	private int Id;
	private String Descricao;
	private double ValorMinimo;
	private boolean Status;
	
	// Construtores
	
	// Construtor Default
	public Leilao() {}
	
	// Construtor parametrizado
	public Leilao(int Id, String Descricao, double ValorMinimo, boolean Status) throws Exception {
		setId(Id);
		setDescricao(Descricao);
		setValorMinimo(ValorMinimo);
		setStatus(Status);;
	}
	
	// Getters e Setters
	
	// Getters
	public int getId() {
        return Id;
    }
	
	public String getDescricao() {
        return Descricao;
    }
	
	public double getValorMinimo() {
        return ValorMinimo;
    }
	
	public boolean getStatus() {
        return Status;
    }
	
	// Setters
	public void setId(int id) throws Exception {
		Verificacoes.isIdValido(id);
		Id = id;
	}
	
	public void setDescricao(String descricao) throws Exception {
		Verificacoes.isDescricaoValida(descricao);
		Descricao = descricao;
	}
	
	public void setValorMinimo(double valorMinimo) throws Exception {
		Verificacoes.isValorValido(valorMinimo);
		ValorMinimo = valorMinimo;
	}
	
	public void setStatus(boolean status) {
		Status = status;
	}
	
	// Método ToString
    @Override
    public String toString() {
        return "Leilao [Id=" + Id + ", Descricao=" + Descricao + ", ValorMinimo=" + ValorMinimo + ", Status=" + Status + "]";
    }
}
