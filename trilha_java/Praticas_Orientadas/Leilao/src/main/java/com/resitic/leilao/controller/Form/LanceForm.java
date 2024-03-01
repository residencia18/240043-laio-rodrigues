package com.resitic.leilao.controller.Form;

public class LanceForm {
	private int Id_Leilao;
	private int Id_Concorrente;
	private double Valor;
	
	public LanceForm() {}
	
	public LanceForm(int id_leilao, int id_concorrente, double valor) {
		Id_Leilao = id_leilao;
        Id_Concorrente = id_concorrente;
        Valor = valor;
	}

	public int getId_Leilao() {
		return Id_Leilao;
	}

	public void setId_Leilao(int id_Leilao) {
		Id_Leilao = id_Leilao;
	}

	public int getId_Concorrente() {
		return Id_Concorrente;
	}

	public void setId_Concorrente(int id_Concorrente) {
		Id_Concorrente = id_Concorrente;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}
	
	@Override
    public String toString() {
        return "LanceForm [Id_Leilao=" + Id_Leilao + ", Id_Concorrente=" + Id_Concorrente + ", Valor=" + Valor + "]";
    }
	
}
