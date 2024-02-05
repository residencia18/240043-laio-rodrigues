package fatura;

import java.util.Calendar;

public class Reembolso {
	private Calendar Data;
	private int Valor;
	
	public Reembolso() {}
	
	public Reembolso(Calendar data, int Valor) {
		this.Data = data;
        this.Valor = Valor;
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar data) {
        this.Data = data;
    }
	
	public int getValor() {
        return Valor;
    }
	
	public void setValor(int valor) {
        this.Valor = valor;
    }
	
	@Override
    public String toString() {
        return "Reembolso [Data=" + Data + ", Valor=" + Valor + "]";
    }
}
