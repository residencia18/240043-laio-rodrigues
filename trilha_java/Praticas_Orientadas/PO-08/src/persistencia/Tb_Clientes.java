package persistencia;

import java.util.ArrayList;

import cliente.Cliente;

public class Tb_Clientes extends ArrayList<Cliente> {
	private static final long serialVersionUID = 1L;
	
	public void insert(Cliente cliente) throws Exception {
		if (cliente == null) throw new Exception("Um cliente nulo foi passado");
		if (this.contains(cliente)) throw new Exception("O cliente já está cadastrado na lista");
		this.add(cliente);
	}
	
	public void delete(Cliente cliente) throws Exception {
        if (cliente == null) throw new Exception("Um cliente nulo foi passado");
        if (!this.contains(cliente)) throw new Exception("O cliente não está cadastrado na lista");
        this.remove(cliente);
    }
	
	public Cliente findByCPF(String CPF) {
		for (Cliente c : this) 
			if (c.getCPF().equals(CPF))	return c;
		return null;
    }
	
}
