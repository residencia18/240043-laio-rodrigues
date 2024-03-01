package com.resitic.leilao.model;

import com.resitic.leilao.utils.Verificacoes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Lance")
public class Lance {
	// Atributos da classe Lance
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Leilao leilao;
	@ManyToOne(cascade = CascadeType.ALL)
	private Concorrente concorrente;
	@Column(name = "Valor")
	private double valor;
	
	// Construtores
	
	// Construtor Default
	public Lance() {}
	
	// Construtor parametrizado
	public Lance(int id, Leilao leilao, Concorrente concorrente, double valor) throws Exception {
		setId(id);
        setLeilao(leilao);
        setConcorrente(concorrente);
        setValor(valor);
	}
	
	// Getters e Setters
	
	// Getters
    public int getId() {
        return Id;
    }
    
    public Leilao getLeilao() {
        return leilao;
    }
    
    public Concorrente getConcorrente() {
        return concorrente;
    }
    
    public double getValor() {
        return valor;
    }
    
    // Setters
    public void setId(int id) throws Exception {
    	Verificacoes.isIdValido(id);
        Id = id;
    }
    
    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }
    
    public void setConcorrente(Concorrente concorrente) {
        this.concorrente = concorrente;
    }
    
    public void setValor(double valor) throws Exception {
    	Verificacoes.isValorValido(valor);
        this.valor = valor;
    }
    
    // Método ToString
    @Override
    public String toString() {
        return "Lance [Id=" + Id + ", Id_Leilao=" + leilao.getId() + ", Id_Concorrente=" + concorrente.getId() + ", Valor=" + valor + "]";
    }
}
