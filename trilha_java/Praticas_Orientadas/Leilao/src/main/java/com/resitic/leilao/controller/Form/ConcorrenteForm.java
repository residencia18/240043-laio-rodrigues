package com.resitic.leilao.controller.Form;

import com.resitic.leilao.model.Concorrente;

public class ConcorrenteForm {
	private String Nome;
	private String CPF;
	
	public ConcorrenteForm() {}
	
	public ConcorrenteForm(String nome, String cpf) {
		this.Nome = nome;
        this.CPF = cpf;;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	@Override
    public String toString() {
        return "ConcorrenteForm [Nome=" + Nome + ", CPF=" + CPF + "]";
    }
	
	public Concorrente toConcorrente() throws Exception {
		Concorrente concorrente = new Concorrente();
		concorrente.setNome(this.Nome);
		concorrente.setCpf(this.CPF);
		return concorrente;
	}
}
