package br.com.interfaces;

import java.util.ArrayList;

public class TemperaturasDoPeriodo implements DadosEstatisticos {
	protected ArrayList<Integer> Temperaturas = new ArrayList<Integer>();
	
	void setTemperatura(int temperatura) {
		this.Temperaturas.add(temperatura);
	}
	
	@Override
	public Object maximo() {
		this.ordenar();
		return this.Temperaturas.get(this.Temperaturas.size()-1);
	}

	@Override
	public Object minimo() {
		this.ordenar();
		return this.Temperaturas.get(0);
	}

	@Override
	public Object ordenar() {
		this.Temperaturas.sort(null);
		return null;
	}

	@Override
	public Object buscar(Object busca) {
		this.ordenar();
		return this.Temperaturas.indexOf(busca);
	}

}
