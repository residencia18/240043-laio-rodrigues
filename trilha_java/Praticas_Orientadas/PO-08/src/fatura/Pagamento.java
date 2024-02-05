package fatura;

import java.util.Calendar;

public class Pagamento {
	private Calendar Data;
	private int Valor;
	private Reembolso Reembolso = null;
	
	public Pagamento() {}
	
	public Pagamento(Calendar Data, int Valor, Reembolso Reembolso) {
		this.Data = Data;
        this.Valor = Valor;
        this.Reembolso = Reembolso;
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar Data) {
        this.Data = Data;
    }	
	
	public int getValor() {
        return Valor;
    }
	
	public void setValor(int Valor) {
        this.Valor = Valor;
    }
	
	public Reembolso getReembolso() {
        return Reembolso;
    }
	
	public void setReembolso(Reembolso Reembolso) {
        this.Reembolso = Reembolso;
    }
	
	@Override
    public String toString() {
        return "Pagamento [Data=" + Data + ", Valor=" + Valor + ", Reembolso=" + (Reembolso != null ? Reembolso.getValor() : "NÃO HOUVE") + "]";
    }
}
