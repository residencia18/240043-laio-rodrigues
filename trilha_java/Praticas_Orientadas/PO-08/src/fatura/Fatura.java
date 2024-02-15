package fatura;

import java.io.Serializable;
import java.util.Calendar;

import imovel.Imovel;

public class Fatura implements Serializable {
	private static final long serialVersionUID = 1L;
	private Calendar Data;
	private int LeituraAnterior;
	private int LeituraAtual;
	private double Valor;
	private boolean Quitado;
	private Imovel Imovel;
	
	public Fatura() {		
		Quitado = false;
		Calendar Data = Calendar.getInstance();
		this.Data = Data;
	}
	
	public Fatura(Calendar Data, int LeituraAnterior, int LeituraAtual, double Valor, boolean Quitado, Imovel Imovel) throws Exception {
		setData(Data);
		setLeituras(LeituraAnterior, LeituraAtual);
		setValor(Valor);
		setQuitado(Quitado);
		setImovel(Imovel);
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar Data) throws Exception {
		if (Data == null) throw new Exception("A data não pode ser nula");
        this.Data = Data;
    }
	
	public int getLeituraAnterior() {
        return LeituraAnterior;
    }
	
	public int getLeituraAtual() {
        return LeituraAtual;
    }
	
	public void setLeituras(int LeituraAnterior, int LeituraAtual) throws Exception {
		if (LeituraAnterior < 0 || LeituraAtual < 0) throw new Exception("A leitura não pode ser negativa");
		if (LeituraAtual < LeituraAnterior) throw new Exception("A leitura atual não pode ser menor que a anterior");
		this.LeituraAnterior = LeituraAnterior;
        this.LeituraAtual = LeituraAtual;
    }	
	
	public double getValor() {
        return Valor;
    }
	
	public int getConsumo() {
		return LeituraAtual - LeituraAnterior;
	}
	
	public void setValor(double Valor) throws Exception {
		if (Valor < 0) throw new Exception("O valor da fatura não pode ser negativo");
        this.Valor = Valor;
    }
	
	public void calcularValor() {
        this.Valor = getConsumo()*10;
    }
	
	public boolean isQuitado() {
        return Quitado;
    }
	
	public void setQuitado(boolean Quitado) {
        this.Quitado = Quitado;
    }
	
	public Imovel getImovel() {
        return Imovel;
    }
	
	public void setImovel(Imovel Imovel) throws Exception {
		if (Imovel == null) throw new Exception("O imóvel não pode ser nulo");
		this.Imovel = Imovel;
	}
	
	@Override
    public String toString() {
        return "Fatura [Data=" + Data.getTime() + ", Imóvel=" + Imovel.getMatricula() + ", Consumo=" + getConsumo() + ", Valor=" + Valor + ", Quitado=" + (Quitado ? "SIM" : "NÃO") + "]";
    }
}
