package persistencia;

import java.util.ArrayList;

import fatura.Fatura;
import fatura.Pagamento;

public class Tb_Pagamentos extends ArrayList<Pagamento> {
	private static final long serialVersionUID = 1L;
	
	public void insert(Pagamento pagamento) throws Exception {
		if (pagamento == null) throw new Exception("Um pagamento nulo foi passado");
		if (this.contains(pagamento)) throw new Exception("O pagamento já está cadastrado na lista");
		this.add(pagamento);
	}
	
	public void delete(Pagamento pagamento) throws Exception {
        if (pagamento == null) throw new Exception("Um pagamento nulo foi passado");
        if (!this.contains(pagamento)) throw new Exception("O pagamento não está cadastrado na lista");
        this.remove(pagamento);
    }
	
	public void update(Pagamento pagamento) throws Exception {
		if (pagamento == null) throw new Exception("Um pagamento nulo foi passado");
        if (!this.contains(pagamento)) throw new Exception("O pagamento não está cadastrado na lista");
        this.set(this.indexOf(pagamento), pagamento);
	}
	
	public ArrayList<Pagamento> findAllByFatura(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passada");
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getFatura().equals(fatura)) pagamentos.add(pagamento);
        }
        return pagamentos;
	}
}
