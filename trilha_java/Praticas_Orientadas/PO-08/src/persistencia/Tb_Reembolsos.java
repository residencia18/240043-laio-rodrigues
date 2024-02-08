package persistencia;

import java.util.ArrayList;

import fatura.Fatura;
import fatura.Reembolso;

public class Tb_Reembolsos extends ArrayList<Reembolso> {
	private static final long serialVersionUID = 1L;

	public void insert(Reembolso reembolso) throws Exception {
		if (reembolso == null) throw new Exception("Um reembolso nulo foi passado");
		if (this.contains(reembolso)) throw new Exception("O reembolso ja está cadastrado na lista");
		this.add(reembolso);
	}
	
	public void delete(Reembolso reembolso) throws Exception {
        if (reembolso == null) throw new Exception("Um reembolso nulo foi passado");
        if (!this.contains(reembolso)) throw new Exception("O reembolso nao está cadastrado na lista");
        this.remove(reembolso);
    }
	
	public void update(Reembolso reembolso) throws Exception {
		if (reembolso == null) throw new Exception("Um reembolso nulo foi passado");
        if (!this.contains(reembolso)) throw new Exception("O reembolso nao está cadastrado na lista");
        this.set(this.indexOf(reembolso), reembolso);
	}
	
	public Reembolso findByFatura(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passada");
		for (Reembolso reembolso : this) {
            if (reembolso.getPagamento().getFatura().equals(fatura)) return reembolso;
        }
        return null;
	}
}
