package persistencia;

import java.util.ArrayList;

import cliente.Cliente;
import imovel.Imovel;

public class Tb_Imoveis extends ArrayList<Imovel> {
	private static final long serialVersionUID = 1L;

	public void insert(Imovel imovel) throws Exception {
		if (imovel == null) throw new Exception("Um imovel nulo foi passado");
		if (this.contains(imovel)) throw new Exception("O imóvel já está cadastrado na lista");
		this.add(imovel);
	}
	
	public void delete(Imovel imovel) throws Exception {
        if (imovel == null) throw new Exception("Um imovel nulo foi passado");
        if (!this.contains(imovel)) throw new Exception("O imóvel não está cadastrado na lista");
        this.remove(imovel);
    }
	
	public Imovel findByMatricula(String matricula) throws Exception {
		if (matricula == null) throw new Exception("Um matricula nula foi passado");
		for (Imovel imovel : this)
            if (imovel.getMatricula().equals(matricula)) return imovel;
        return null;
	}
	
	public ArrayList<Imovel> findAllByProprietario(Cliente proprietario) throws Exception {
		if (proprietario == null) throw new Exception("Um proprietário nulo foi passado");
		ArrayList<Imovel> lista = new ArrayList<Imovel>();
        for (Imovel imovel : this) {        	
            if (imovel.getProprietario().equals(proprietario)) 
            	lista.add(imovel);
        }
        return lista;
	}
}
