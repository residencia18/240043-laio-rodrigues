package br.com.faturamento;
import java.time.LocalDate;
import java.util.*;
import java.text.DecimalFormat;


public class Pagamento {
    protected double valor;
    protected LocalDate data;

    public Pagamento(double valor) {
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public static Pagamento obterDadosPagamento() {
    	
        Pagamento pagamento;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("Informe o valor do pagamento: ");
			double valorPagamento = scanner.nextDouble();

			pagamento = new Pagamento(valorPagamento);
			return pagamento;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Pagamento no valor de R$%s realizado na data %s!", df.format(valor), data);
    }
}