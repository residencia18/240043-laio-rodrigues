package br.com.interfaces;

import java.util.ArrayList;
import java.util.Calendar;

public class DtNasc implements DadosEstatisticos {
	protected ArrayList<Calendar> lista;
	
	DtNasc(){
		this.lista = new ArrayList<Calendar>();
	}
	
	void setData(int dia, int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		cal.set(ano, mes-1, dia);
		this.lista.add(cal);
	}
	
	@Override
	public Object maximo() {
		this.ordenar();
		return this.lista.get(this.lista.size()-1);
	}

	@Override
	public Object minimo() {
		this.ordenar();
		return this.lista.get(0);
	}

	@Override
	public Object ordenar() {
		this.lista.sort(null);
		return null;
	}

	@Override
	public Object buscar(Object busca) {
		this.ordenar();
		Calendar cal = (Calendar) busca;
		return this.lista.indexOf(cal);
	}

}
