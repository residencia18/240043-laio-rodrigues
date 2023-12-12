package br.com.poligono;

import java.util.ArrayList;


public class Poligono {
	ArrayList<Ponto> pontos;
	
	public Poligono() {
		pontos = new ArrayList<Ponto>();
	}
	
	public void inserePonto(Ponto novo) {
		pontos.add(novo);
	}
	
	public float perimetro() throws NullPointerException{
		float per = 0;
		Ponto p1, p2 = null;
		for (int i = 0; i < pontos.size()-1; i++) {
			p1 = pontos.get(i);
			p2 = pontos.get(i+1);
			per += p1.calcularDistancia(p2);
		}
		p1 = pontos.get(0);
		per += p1.calcularDistancia(p2);
		return per;
	}
}
