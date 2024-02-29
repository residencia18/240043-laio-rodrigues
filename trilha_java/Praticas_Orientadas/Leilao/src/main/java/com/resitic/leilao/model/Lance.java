package com.resitic.leilao.model;

import com.resitic.leilao.utils.Verificacoes;

public class Lance {
	// Atributos da classe Lance
	private int Id;
	private int Id_Leilao;
	private int Id_Concorrente;
	private double Valor;
	
	// Construtores
	
	// Construtor Default
	public Lance() {}
	
	// Construtor parametrizado
	public Lance(int id, int id_leilao, int id_concorrente, double valor) throws Exception {
		setId(id);
        setId_Leilao(id_leilao);
        setId_Concorrente(id_concorrente);
        setValor(valor);
	}
	
	// Getters e Setters
	
	// Getters
    public int getId() {
        return Id;
    }
    
    public int getId_Leilao() {
        return Id_Leilao;
    }
    
    public int getId_Concorrente() {
        return Id_Concorrente;
    }
    
    public double getValor() {
        return Valor;
    }
    
    // Setters
    public void setId(int id) throws Exception {
    	Verificacoes.isIdValido(id);
        Id = id;
    }
    
    public void setId_Leilao(int id_leilao) throws Exception {
    	Verificacoes.isIdValido(id_leilao);
        Id_Leilao = id_leilao;
    }
    
    public void setId_Concorrente(int id_concorrente) throws Exception {
    	Verificacoes.isIdValido(id_concorrente);
        Id_Concorrente = id_concorrente;
    }
    
    public void setValor(double valor) throws Exception {
    	Verificacoes.isValorValido(valor);
        Valor = valor;
    }
    
    // Método ToString
    @Override
    public String toString() {
        return "Lance [Id=" + Id + ", Id_Leilao=" + Id_Leilao + ", Id_Concorrente=" + Id_Concorrente + ", Valor=" + Valor + "]";
    }
}
