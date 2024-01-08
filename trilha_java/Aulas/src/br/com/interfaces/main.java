package br.com.interfaces;

import java.util.ArrayList;
import java.util.Calendar;

public class main {
	
	public static void main(String[] args) {
		CidadesDoBrasil listaCidades = new CidadesDoBrasil();
		DtNasc listaDatas = new DtNasc();
		TemperaturasDoPeriodo listaTemperaturas = new TemperaturasDoPeriodo();
		
		listaCidades.setCidade("Camacan");
		listaCidades.setCidade("Itabuna");
		listaCidades.setCidade("Ilheus");
		
		listaTemperaturas.setTemperatura(25);
		listaTemperaturas.setTemperatura(31);
		listaTemperaturas.setTemperatura(12);
		
		listaDatas.setData(8, 01, 2024);
		listaDatas.setData(12, 10, 2023);
		listaDatas.setData(05, 05, 2080);
		
		Calendar data = (Calendar)listaDatas.minimo();
		System.out.println("A data minima: " + data.getTime());
		data = (Calendar)listaDatas.maximo();
		System.out.println("A data máxima: " + data.getTime());
		int ano = 2024;
		int mes = 01;
		int dia = 8;
		Calendar cal = Calendar.getInstance();
		cal.set(ano, mes-1, dia);
		int loc = (int)listaDatas.buscar(cal);
		if(loc != -1)
			System.out.println("A data esta na posição " + loc);
		else
			System.out.println(loc);
		
		String cidade = (String)listaCidades.minimo();
		System.out.println("A cidade minima: " + cidade);
		cidade = (String)listaCidades.maximo();
		System.out.println("A cidade máxima: " + cidade);
		int loca = (int)listaCidades.buscar("Ilheus");
		if(loca != -1)
			System.out.println("A data esta na posição " + loca);
		else
			System.out.println(loca);
	}	
}
