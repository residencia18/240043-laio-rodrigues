package fatura;

import java.io.Serializable;
import java.util.Calendar;

public class Reembolso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Calendar Data;
	private double Valor;
	private Pagamento Pagamento;
	
	public Reembolso() {
		Calendar cal = Calendar.getInstance();
		this.Data = cal;
	}
		
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar data) throws Exception {
		if (data == null) throw new Exception("A data não pode ser nula");
        this.Data = data;
    }
	
	public double getValor() {
        return Valor;
    }
	
	public void setValor(double valor) throws Exception {
		if (valor < 0) throw new Exception("O valor do reembolso não pode ser negativo");
        this.Valor = valor;
    }
	
	public Pagamento getPagamento() {
        return Pagamento;
    }
	
	public void setPagamento(Pagamento pagamento) throws Exception {
		if (pagamento == null) throw new Exception("O pagamento não pode ser nulo");
        this.Pagamento = pagamento;
    }
	
	@Override
    public String toString() {
        return "Reembolso [Data=" + Data.getTime() + ", Valor=" + Valor + "]";
    }
}
