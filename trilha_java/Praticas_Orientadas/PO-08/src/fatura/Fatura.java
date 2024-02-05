package fatura;

import java.util.ArrayList;
import java.util.Calendar;

public class Fatura {
	private Calendar Data;
	private int LeituraAnterior;
	private int LeituraAtual;
	private int Valor;
	private boolean Quitado;
	private ArrayList<Pagamento> Pagamentos = new ArrayList<Pagamento>();
	
	public Fatura() {}
	
	public Fatura(Calendar Data, int LeituraAnterior, int LeituraAtual, int Valor, boolean Quitado) {
		super();
        this.Data = Data;
        this.LeituraAnterior = LeituraAnterior;
        this.LeituraAtual = LeituraAtual;
        this.Valor = Valor;
        this.Quitado = Quitado;
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar Data) {
        this.Data = Data;
    }
	
	public int getLeituraAnterior() {
        return LeituraAnterior;
    }
	
	public int getLeituraAtual() {
        return LeituraAtual;
    }
	
	public void setLeituraAtual(int Leitura) {
		this.LeituraAnterior = this.LeituraAtual;
        this.LeituraAtual = Leitura;
    }
	
	public int getValor() {
        return Valor;
    }
	
	public int getConsumo() {
		return LeituraAtual - LeituraAnterior;
	}
	
	public void setValor() {
        this.Valor = getConsumo()*10;
    }
	
	public boolean isQuitado() {
        return Quitado;
    }
	
	public void setQuitado(boolean Quitado) {
        this.Quitado = Quitado;
    }
	
	public ArrayList<Pagamento> getPagamentos() {
        return Pagamentos;
    }
	
	public void addPagamento(Pagamento Pagamento) {
		Pagamentos.add(Pagamento);
	}
	
	@Override
    public String toString() {
        return "Fatura [Data=" + Data + ", Consumo=" + getConsumo() + ", Valor=" + Valor + ", Quitado=" + (Quitado ? "SIM" : "NÃO") + "]";
    }
}
