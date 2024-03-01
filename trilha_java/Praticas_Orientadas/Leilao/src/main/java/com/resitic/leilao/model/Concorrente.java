package com.resitic.leilao.model;

import java.util.List;

import com.resitic.leilao.utils.Verificacoes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Concorrente")
public class Concorrente {
	// Atributos da classe Concorrente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "Nome")
	private String Nome;
	@Column(name = "CPF")
	private String CPF;
	@OneToMany(mappedBy = "concorrente", cascade = CascadeType.ALL)
	private List<Lance> Lances;
	
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
