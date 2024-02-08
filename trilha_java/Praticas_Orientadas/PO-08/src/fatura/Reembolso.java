package fatura;

import java.util.Calendar;

public class Reembolso {
	private Calendar Data;
	private int Valor;
	private Pagamento Pagamento;
	
	public Reembolso(Calendar data, int Valor, Pagamento Pagamento) throws Exception {
		setData(data);
		setValor(Valor);
		setPagamento(Pagamento);
	}
	
	public Calendar getData() {
        return Data;
    }
	
	public void setData(Calendar data) throws Exception {
		if (data == null) throw new Exception("A data não pode ser nula");
        this.Data = data;
    }
	
	public int getValor() {
        return Valor;
    }
	
	public void setValor(int valor) throws Exception {
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
        return "Reembolso [Data=" + Data + ", Valor=" + Valor + "]";
    }
}
