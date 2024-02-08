package fatura;

import java.util.Calendar;

import imovel.Imovel;

public class Fatura {
	private Calendar Data;
	private int LeituraAnterior;
	private int LeituraAtual;
	private int Valor;
	private boolean Quitado;
	private Imovel Imovel;
	
	public Fatura(Calendar Data, Imovel Imovel) throws Exception {
		setData(Data);
        setImovel(Imovel);
        LeituraAnterior = this.Imovel.getLeituraAterior();
        LeituraAtual = this.Imovel.getLeituraAtual();
        Quitado = false;
        calcularValor();;
	}
	
	public Fatura(Calendar Data, int LeituraAnterior, int LeituraAtual, int Valor, boolean Quitado, Imovel Imovel) throws Exception {
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
	
	public int getValor() {
        return Valor;
    }
	
	public int getConsumo() {
		return LeituraAtual - LeituraAnterior;
	}
	
	public void setValor(int Valor) throws Exception {
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
        return "Fatura [Data=" + Data + ", Imóvel=" + Imovel.getMatricula() + ", Consumo=" + getConsumo() + ", Valor=" + Valor + ", Quitado=" + (Quitado ? "SIM" : "NÃO") + "]";
    }
}
