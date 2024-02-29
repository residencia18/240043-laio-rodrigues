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
@Table(name = "Tb_Leilao")
public class Leilao {
	
	// Atributos da classe Leilão
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "Descricao")
	private String Descricao;
	@Column(name = "Valor_Minimo")
	private double ValorMinimo;
	@Column(name = "Status")
	private boolean Status;
	@OneToMany(mappedBy = "Tb_Leilao", cascade = CascadeType.ALL)
	private List<Lance> Lances;
	
	// Construtores
	
	// Construtor Default
	public Leilao() {}
	
	// Construtor parametrizado
	public Leilao(int Id, String Descricao, double ValorMinimo, boolean Status) throws Exception {
		setId(Id);
		setDescricao(Descricao);
		setValorMinimo(ValorMinimo);
		setStatus(Status);
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
