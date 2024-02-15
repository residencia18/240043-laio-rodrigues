package fatura;

import java.io.Serializable;
import java.util.Calendar;

public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Calendar Data;
	private double Valor;
	private Fatura Fatura;
		
	public Pagamento() {
		Calendar cal = Calendar.getInstance();
		this.Data = cal;
	}
	
	public Pagamento(Calendar Data, double Valor, Fatura Fatura) throws Exception {
		setData(Data);
		setValor(Valor);
		setFatura(Fatura);
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar Data) throws Exception {
		if (Data == null) throw new Exception("A data não pode ser nula");
        this.Data = Data;
	}
	
	public double getValor() {
        return Valor;
    }
	
	public void setValor(double Valor) throws Exception {
		if (Valor < 0) throw new Exception("O valor do pagamento não pode ser negativo");
        this.Valor = Valor;
    }
	
	public Fatura getFatura() {
		return Fatura;
    }
	
	public void setFatura(Fatura Fatura) throws Exception {
		if (Fatura == null) throw new Exception("A fatura não pode ser nula");
		this.Fatura = Fatura;
    }
	
	@Override
    public String toString() {
        return "Pagamento [Data=" + Data.getTime() + ", Valor=" + Valor + "]";
    }
}
