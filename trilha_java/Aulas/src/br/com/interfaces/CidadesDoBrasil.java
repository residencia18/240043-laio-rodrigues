package br.com.interfaces;

import java.util.ArrayList;

public class CidadesDoBrasil implements DadosEstatisticos {
	protected ArrayList<String> cidades = new ArrayList<String>();
	
	void setCidade(String cidade) {
		this.cidades.add(cidade);
	}
	
	@Override
	public Object maximo() {
		this.ordenar();
		return this.cidades.get(this.cidades.size()-1);
	}

	@Override
	public Object minimo() {
		this.ordenar();
		return this.cidades.get(0);
	}

	@Override
	public Object ordenar() {
		this.cidades.sort(null);
		return null;
	}

	@Override
	public Object buscar(Object busca) {
		this.ordenar();
		return this.cidades.indexOf(busca);
	}

}
