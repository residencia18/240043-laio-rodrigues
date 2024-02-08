package persistencia;

import java.util.ArrayList;

import fatura.Fatura;
import imovel.Imovel;

public class Tb_Faturas extends ArrayList<Fatura> {
	private static final long serialVersionUID = 1L;

	public void insert(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passado");
		if (this.contains(fatura)) throw new Exception("A fatura já está cadastrada na lista");
		this.add(fatura);
	}
	
	public void update(Fatura fatura) throws Exception {
        if (fatura == null) throw new Exception("Uma fatura nula foi passada");
        if (!this.contains(fatura)) throw new Exception("A fatura não está cadastrada na lista");
        this.set(this.indexOf(fatura), fatura);
    }
	
	public void delete(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passada");
        if (!this.contains(fatura)) throw new Exception("A fatura não está cadastrada na lista");
        this.remove(fatura);
	}
	
	public ArrayList<Fatura> findAllByImovel(Imovel imovel) throws Exception {
		if (imovel == null) throw new Exception("Um imóvel nulo foi passado");
        ArrayList<Fatura> faturas = new ArrayList<Fatura>();
        for (Fatura fatura : this) {
            if (fatura.getImovel().getMatricula().equals(imovel.getMatricula())) {
                faturas.add(fatura);
            }
        }
        return faturas;
	}
}
