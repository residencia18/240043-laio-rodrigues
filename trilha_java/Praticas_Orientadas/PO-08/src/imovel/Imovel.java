package imovel;

import java.util.ArrayList;

import fatura.Fatura;

public class Imovel {
	private String Matricula;
	private String Endereco;
	private int Leitura;
	private ArrayList<Fatura> Faturas = new ArrayList<Fatura>();
	
	public Imovel() {}
	
	public Imovel(String Matricula, String Endereco, int Leitura) {
		this.Matricula = Matricula;
        this.Endereco = Endereco;
        this.Leitura = Leitura;;
	}
	
	public String getMatricula() {
        return Matricula;
    }
	
	public String getEndereco() {
        return Endereco;
    }
	
	public int getLeitura() {
        return Leitura;
    }
	
	public ArrayList<Fatura> getFaturas() {
        return Faturas;
    }
	
	public void addFatura(Fatura nova) {
		this.Faturas.add(nova);
	}
	
	public void setLeituraAtual(int leitura) {
        this.Leitura = leitura;
    }
	
	public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }
	
	public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
	
	@Override
    public String toString() {
        return "Imovel [Matricula=" + Matricula + ", Endereco=" + Endereco + ", Leitura=" + Leitura + "]";
    }
}
