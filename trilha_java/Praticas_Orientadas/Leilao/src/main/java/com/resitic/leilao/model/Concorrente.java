package com.resitic.leilao.model;

import com.resitic.leilao.utils.Verificacoes;

public class Concorrente {
	// Atributos da classe Concorrente
	private int Id;
	private String Nome;
	private String CPF;
	
	// Construtores
	
	// Construtor Default
	public Concorrente() {}
	
	// Construtor parametrizado
	public Concorrente(int Id, String Nome, String CPF) throws Exception {
		setId(Id);
        setNome(Nome);
        setCpf(CPF);
    }
	
	// Getters e Setters
	
	// Getters
	public int getId() {
        return Id;
    }
	
	public String getNome() {
        return Nome;
    }
	
	public String getCpf() {
        return CPF;
    }
	
	// Setters
	public void setId(int Id) throws Exception {
		Verificacoes.isIdValido(Id);
        this.Id = Id;
    }
	
	public void setNome(String Nome) throws Exception {
		Verificacoes.isNomeValido(Nome);
        this.Nome = Nome;
    }
	
	public void setCpf(String CPF) throws Exception {
		Verificacoes.isCPFValido(CPF);
        this.CPF = CPF;
    }
	
	// Método ToString
	@Override
    public String toString() {
        return "Concorrente [Id=" + Id + ", Nome=" + Nome + ", CPF=" + CPF + "]";
    }
}
