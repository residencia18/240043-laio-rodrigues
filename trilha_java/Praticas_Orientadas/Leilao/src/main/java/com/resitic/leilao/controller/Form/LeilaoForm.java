package com.resitic.leilao.controller.Form;

import com.resitic.leilao.model.Leilao;

public class LeilaoForm {
	private String Descricao;
	private double ValorMinimo;
	private boolean Status;
	
	public LeilaoForm() {}
	
	public LeilaoForm(String descricao, double valorMinimo, boolean status) {
		Descricao = descricao;
        ValorMinimo = valorMinimo;
        Status = status;;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public double getValorMinimo() {
		return ValorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		ValorMinimo = valorMinimo;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}
	
	@Override
    public String toString() {
        return "LeilaoForm [Descricao=" + Descricao + ", ValorMinimo=" + ValorMinimo + ", Status=" + Status + "]";
    }
	
	public Leilao toLeilao() throws Exception {
		Leilao leilao = new Leilao();
		leilao.setDescricao(Descricao);
		leilao.setValorMinimo(ValorMinimo);
		leilao.setStatus(Status);
		return leilao;
	}
}
