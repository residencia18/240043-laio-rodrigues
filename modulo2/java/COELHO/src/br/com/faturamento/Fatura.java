package br.com.faturamento;
import java.time.LocalDate;
import java.util.*;
import br.com.uteis.*;
import java.text.DecimalFormat;


public class Fatura {
	private String matriculaImovel;
    private int ultimaLeitura;
    private int penultimaLeitura;
    private double valorTotal;
    private LocalDate dataEmissao;
    private boolean quitado;
    private ArrayList<Pagamento> pagamentos;
    private Reembolso reembolso;

    public Fatura(String matriculaImovel, int ultimaLeitura, int penultimaLeitura) {
        this.matriculaImovel = matriculaImovel;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.dataEmissao = LocalDate.now();
        this.quitado = false;
        this.pagamentos = new ArrayList<>();
        calcularValorFatura();
    }

    public String getMatriculaImovel() {
        return matriculaImovel;
    }

    public int getUltimaLeitura() {
        return ultimaLeitura;
    }

    public int getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }
    
    public ArrayList<Pagamento> getPagamentos(){
    	return pagamentos;
    }
    
    public Reembolso getReembolso() {
    	return reembolso;
    }
    
    public void novoPagamento() {
    	if(quitado) {
    		Utilitarios.cxMsg("A fatura já está quitadaa!");
    		return;
    	}
    	
    	float totalPago = 0;
    	Pagamento novo = Pagamento.obterDadosPagamento();
    	if(novo == null) {
    		Utilitarios.cxMsg("Pagamento não realizado");
    		return;
    	}
    	this.pagamentos.add(novo);
    	
    	for (Pagamento p : pagamentos)
			totalPago += p.valor;
    	
    	if(totalPago < this.valorTotal) {
    		DecimalFormat df = new DecimalFormat("#.##");
            String msg = String.format("A fatura foi parcialmente paga, restando R$%s a pagar!", df.format(this.valorTotal - totalPago));
            Utilitarios.cxMsg(msg);
            return;
    	}
    	
		this.quitado = true;
		Utilitarios.cxMsg("A fatura foi paga!");
		if(totalPago > this.valorTotal) {
			this.reembolso = new Reembolso(totalPago - this.valorTotal);
			Utilitarios.cxMsg(this.reembolso.toString());
		}
    }
    
    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

    public void calcularValorFatura() {
        double custoPorKWh = 10.0;
        this.valorTotal = (ultimaLeitura - penultimaLeitura) * custoPorKWh;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Nº de Matrícula: %s, Consumo: %s, Valor Total: R$%s, Data de Emissão: %s, Quitado: %s]",
                matriculaImovel, ultimaLeitura - penultimaLeitura, df.format(valorTotal), dataEmissao, quitado);
    }
}
