package fatura;

import java.util.Calendar;

public class Pagamento {
	private Calendar Data;
	private int Valor;
	private Fatura Fatura;
		
	public Pagamento(Calendar Data, int Valor, Fatura Fatura) throws Exception {
		setData(Data);
		setValor(Valor);
		setFatura(Fatura);
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar Data) throws Exception {
		if (Data == null) throw new Exception("Data não pode ser nulo");
        this.Data = Data;
	}
	
	public int getValor() {
        return Valor;
    }
	
	public void setValor(int Valor) throws Exception {
		if (Valor < 0) throw new Exception("Valor não pode ser negativo");
        this.Valor = Valor;
    }
	
	public Fatura getFatura() {
		return Fatura;
    }
	
	public void setFatura(Fatura Fatura) throws Exception {
		if (Fatura == null) throw new Exception("Fatura não pode ser nula");
		this.Fatura = Fatura;
    }
	
	@Override
    public String toString() {
        return "Pagamento [Data=" + Data + ", Valor=" + Valor + "]";
    }
}
